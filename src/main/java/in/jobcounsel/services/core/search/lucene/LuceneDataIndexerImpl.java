package in.jobcounsel.services.core.search.lucene;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;

@Service
public class LuceneDataIndexerImpl implements LuceneDataIndexer {

	@Value("${application.data.index.location}")
	private String indexLocation;

	private IndexWriter writer;

	private static final Logger logger = LoggerFactory.getLogger(LuceneDataIndexerImpl.class);

	@Override
	public boolean addDataToIndex(List<Map<String, String>> datas) throws JobServicesException {
		boolean result = true;
		try {
			if (writer == null)
				initializeIndex();

			for (Map<String, String> data : datas) {

				Document doc = createDocument(data);

				writer.addDocument(doc);

				writer.flush();
			}

			writer.commit();

		} catch (Exception e) {
			result = false;

			logger.error("Error During Indexing In Lucene Message : {}", e.getMessage());
			throw new JobServicesException("Lucene Adding Data To Index Exception", "LUCENE_ADD_DATA_EXCEPTION");

		} finally {
			try {
				if (writer != null) {
					writer.flush();
					writer.commit();
				}
			} catch (Exception e) {
				logger.error("Error During Indexing In Lucene Message : {}", e.getMessage());
				throw new JobServicesException("Lucene Adding Data To Index Exception", "LUCENE_ADD_DATA_EXCEPTION");
			}
		}
		return result;
	}

	private void initializeIndex() throws JobServicesException {
		try {
			Directory indexDirectory = FSDirectory.open(Paths.get(indexLocation));
			StandardAnalyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
			writer = new IndexWriter(indexDirectory, iwc);
		} catch (IOException e) {
			logger.error("Error During Initialize Indexing In Lucene Message : {}", e.getMessage());
			throw new JobServicesException("Lucene IO Exception", "LUCENE_IO_EXCEPTION");
		} finally {
			try {
				writer.flush();
				writer.commit();
			} catch (IOException e) {
				logger.error("Error During Initalizing Indexing In Lucene Finally Block Message : {}", e.getMessage());
			}

		}

	}

	private Document createDocument(Map<String, String> data) {
		// TODO Make It enums

		Document document = new Document();

		String id = data.get("ID");
		String jobLocation = data.get("JOBLOCATION");
		String jobQualification = data.get("JOBQUALIFICATION");
		String jobOrganization = data.get("JOBORGANIZATION");

		TextField idField = new TextField("ID", id, Field.Store.YES);
		TextField jobLocationField = new TextField("JOBLOCATION", jobLocation, Field.Store.YES);
		TextField jobQualificationField = new TextField("JOBQUALIFICATION", jobQualification, Field.Store.YES);
		TextField jobOrganizationField = new TextField("JOBORGANIZATION", jobOrganization, Field.Store.YES);

		document.add(idField);
		document.add(jobLocationField);
		document.add(jobQualificationField);
		document.add(jobOrganizationField);

		return document;
	}

	@Override
	public boolean deleteIndexAndReset() throws JobServicesException {
		boolean result = true;
		Long totalRecordsDeleted = 0L;
		if (writer == null)
			initializeIndex();
		else {
			try {
				totalRecordsDeleted = writer.deleteAll();
				logger.debug("Total Index Records Deleted : {}", totalRecordsDeleted);
			} catch (IOException e) {
				logger.error("Exception Occured While Deleting Index Exception Message : {}", e.getLocalizedMessage());
				result = false;
			}
		}
		return result;
	}
}
