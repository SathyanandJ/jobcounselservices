package in.jobcounsel.services.core;

import java.util.List;

import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobDetail;

public interface JobsCoreBusinessHelper {

	public List<Job> extractJobDataFromDB(List<JobCoreModel> jobDBData);
	
	public List<JobDetail> extractFullJobDataFromDB(List<JobCoreModel> jobDBData); 
	
}
