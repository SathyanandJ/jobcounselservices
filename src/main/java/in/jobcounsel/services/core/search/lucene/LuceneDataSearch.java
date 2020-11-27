package in.jobcounsel.services.core.search.lucene;

import java.util.List;

import in.jobcounsel.platform.exception.JobServicesException;

public interface LuceneDataSearch {
	
	public List<Long> doSearchIndex(String query,int sector) throws JobServicesException;

}
