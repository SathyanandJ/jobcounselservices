package in.jobcounsel.services.core.search.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;

@Service
public class LuceneDataSearchImpl implements LuceneDataSearch {

	private IndexSearcher indexSearcher = null;
	private QueryParser queryParser = null;
	private Query query = null;

	@Value("${application.data.index.location}")
	private String indexLocation;

	private static final Logger logger = LoggerFactory.getLogger(LuceneDataSearchImpl.class);

	@Override
	public List<Long> doSearchIndex(String queryStr, int sector) throws JobServicesException {
		List<Long> jobIds = new ArrayList<>();
		try {
			if (indexSearcher == null)
				intitalize();

			query = queryParser.parse("+"+queryStr);
			TopDocs docs = indexSearcher.search(query, Integer.MAX_VALUE);

			logger.debug("Total Search Result : {}", docs.totalHits);

			for (ScoreDoc scoreDoc : docs.scoreDocs) {
				Document doc = indexSearcher.doc(scoreDoc.doc);
				Long jobId = doc.get("ID") != null ? Long.valueOf(doc.get("ID")) : 0;
				jobIds.add(jobId);
			}

		} catch (Exception e) {
			logger.error("Exception While Executing the Operation To Search The Index Error Message : {}",
					e.getMessage());
			throw new JobServicesException("Error In Searching the Index", "LuceneDataSearchImpl_doSearchIndex");
		}
		return jobIds;
	}

	private void intitalize() throws IOException {
		Directory indexDirectory = FSDirectory.open(Paths.get(indexLocation));
		IndexReader reader = DirectoryReader.open(indexDirectory);
		indexSearcher = new IndexSearcher(reader);

		String fields[] = { "JOBLOCATION", "JOBQUALIFICATION","JOBORGANIZATION","JOBDESIGNATION" };

		queryParser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
	}

}
