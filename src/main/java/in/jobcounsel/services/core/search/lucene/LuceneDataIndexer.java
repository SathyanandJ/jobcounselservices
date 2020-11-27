package in.jobcounsel.services.core.search.lucene;

import java.util.List;
import java.util.Map;

import in.jobcounsel.platform.exception.JobServicesException;

public interface LuceneDataIndexer {

	public boolean addDataToIndex(List<Map<String, String>> data) throws JobServicesException;
	
	public boolean deleteIndexAndReset() throws JobServicesException;

}
