package in.jobcounsel.services.core;

import java.util.List;

import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@Service
public interface JobCounselServicesCore {
	
	public JobCount getAllJobsCount() throws JobServicesException;

	public List<Job> getAllJobsByCategory(Integer categoryId) throws JobServicesException;

	public List<Job>  getAllJobs(Integer categoryId, Integer typeId) throws JobServicesException;

	public JobDetail getJobDetails(Long jobId) throws JobServicesException;

	public List<Sector> getAllSectors() throws JobServicesException;
	
	public List<Branch> getAllBranches() throws JobServicesException;
	
	public List<Organization> getAllOrganization() throws JobServicesException;
	
	public Job saveJob(JobReq jobReq) throws JobServicesException;

}
