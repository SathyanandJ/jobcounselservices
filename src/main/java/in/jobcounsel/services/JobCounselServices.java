package in.jobcounsel.services;

import java.util.List;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

public interface JobCounselServices {

	public JobCount getAllJobsCount() throws JobServicesException;

	public List<Job> getAllJobsByCategory(Integer categoryId) throws JobServicesException;

	public  List<Job> getAllJobs(Integer categoryId, Integer typeId) throws JobServicesException;

	public Job getJobDetails(Long jobId) throws JobServicesException;

	public List<Sector> getAllSectors() throws JobServicesException;
	
	public List<Branch> getAllBranches() throws JobServicesException;
	
	public List<Organization> getAllOrganizations() throws JobServicesException;

}
