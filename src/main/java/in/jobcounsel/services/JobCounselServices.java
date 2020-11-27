package in.jobcounsel.services;

import java.util.List;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

public interface JobCounselServices {

	public JobCount getAllJobsCount() throws JobServicesException;

	public List<Job> getAllJobsBySector(Integer sectorId) throws JobServicesException;

	public  List<Job> getAllJobsBySectorAndBranch(Integer sectorId, Integer branchId) throws JobServicesException;

	public JobDetail getJobDetails(Long jobId) throws JobServicesException;

	public List<Sector> getAllSectors() throws JobServicesException;
	
	public List<Branch> getAllBranches() throws JobServicesException;
	
	public List<Organization> getAllOrganizations() throws JobServicesException;

	public Job saveJob(JobReq jobReq) throws JobServicesException;

	public List<Job> searchJobs(String searchQuery, Long sectorID) throws JobServicesException;
}
