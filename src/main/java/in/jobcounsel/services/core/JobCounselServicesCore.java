package in.jobcounsel.services.core;

import java.util.List;

import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.HiringOrgResponse;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.LatestJobNotificationResp;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@Service
public interface JobCounselServicesCore {

	public JobCount getAllJobsCount() throws JobServicesException;

	public List<Job> getAllJobsBySector(Integer sectorId) throws JobServicesException;

	public List<Job> getAllJobsBySectorAndBranch(Integer sectorId, Integer branchId) throws JobServicesException;

	public JobDetail getJobDetails(Long jobId) throws JobServicesException;

	public List<Sector> getAllSectors() throws JobServicesException;

	public List<Branch> getAllBranches() throws JobServicesException;

	public List<Organization> getAllOrganization() throws JobServicesException;

	public Job saveJob(JobReq jobReq) throws JobServicesException;

	public List<Job> searchJobs(String searchQuery, Long sectorID) throws JobServicesException;

	public Boolean saveUserSubscription(String emailId) throws JobServicesException;

	public String confirmEmailGUID(String confirmationEmailGUID) throws JobServicesException;

	public String unsubscribeEmail(String unsubscribeId) throws JobServicesException;
	
	public Boolean sendJobNotificationToSubscribers() throws JobServicesException;

	public List<LatestJobNotificationResp> jobMessages() throws JobServicesException;

	public HiringOrgResponse hiringOrganizations(String sectorId) throws JobServicesException;

	public List<Job> getAllJobsForOrg(Long orgId) throws JobServicesException;

}
