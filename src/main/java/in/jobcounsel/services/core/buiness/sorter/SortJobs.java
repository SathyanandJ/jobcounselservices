package in.jobcounsel.services.core.buiness.sorter;

import java.util.List;

import in.jobcounsel.services.core.models.JobCoreModel;

public interface SortJobs {
	
	public List<JobCoreModel> sortJobsNextExpiryFirst(List<JobCoreModel> unsortedJobs);

}
