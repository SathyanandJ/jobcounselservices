package in.jobcounsel.services.core.search.lucene;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.core.search.DataSearchOperations;

@Service
public class DataSearchOperationsLucene implements DataSearchOperations{

	@Autowired
	LuceneDataIndexer dataIndexer;
	
	@Autowired
	LuceneDataSearch dataSearch;
	
	private static final Logger logger = LoggerFactory.getLogger(DataSearchOperationsLucene.class);
	
	@Override
	public boolean addDataToIndex(List<Map<String, String>> datas) {
		boolean result = true;
		try {
			dataIndexer.addDataToIndex(datas);
		}catch(Exception e) {
			logger.error("Error Occured While adding Data To Index");
			result = false;
		}
		return result;
	}

	@Override
	public boolean removeDataInIndex(Map<String, String> data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Long> searchDataInIndex(String query,int sector) {
		List<Long> jobsThatMatchSearch = new ArrayList<>();
		try{
			jobsThatMatchSearch = dataSearch.doSearchIndex(query, sector);
		}catch(Exception e) {
			logger.error("Error Occured While searching for Jobs In Lucene Error Message : {}",e.getLocalizedMessage());
			
		}
		return jobsThatMatchSearch;
	}

	@Override
	public boolean resetDataInIndex() {
		boolean result = true;
		try {
			result = dataIndexer.deleteIndexAndReset();
		} catch (JobServicesException e) {
			logger.error("Error Occured While Deleting and Resetting Index");
			result = false;
		}
		return result;
	}

}
