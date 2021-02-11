package in.jobcounsel.services;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.core.JobCounselServicesCore;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.HiringOrgResponse;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.JobMessage;
import in.jobcounsel.services.response.LatestJobNotificationResp;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.OrganizationsHiring;
import in.jobcounsel.services.response.Sector;

@Service
public class JobCounselServicesImpl implements JobCounselServices{
	
	@Autowired
	JobCounselServicesCore jobCounselServiceCore;

	Logger logger = LoggerFactory.getLogger(JobCounselServicesImpl.class);
	
	@Override
	public JobCount getAllJobsCount() throws JobServicesException {
		return jobCounselServiceCore.getAllJobsCount();
	}

	@Override
	public List<Job> getAllJobsBySector(Integer sectorId) throws JobServicesException {
		return jobCounselServiceCore.getAllJobsBySector(sectorId);
	}

	@Override
	public  List<Job> getAllJobsBySectorAndBranch(Integer sectorId, Integer branchId) throws JobServicesException {
		return jobCounselServiceCore.getAllJobsBySectorAndBranch(sectorId, branchId);
	}

	@Override
	public JobDetail getJobDetails(Long jobId) throws JobServicesException {
		return jobCounselServiceCore.getJobDetails(jobId);
	}

	@Override
	public List<Sector> getAllSectors() throws JobServicesException {
		return jobCounselServiceCore.getAllSectors();
	}

	@Override
	public List<Branch> getAllBranches() throws JobServicesException {
		return jobCounselServiceCore.getAllBranches();
	}

	@Override
	public List<Organization> getAllOrganizations() throws JobServicesException {
		return jobCounselServiceCore.getAllOrganization();
	}

	@Override
	public Job saveJob(JobReq jobReq) throws JobServicesException {
		return jobCounselServiceCore.saveJob(jobReq);
	}

	@Override
	public List<Job> searchJobs(String searchQuery, Long sectorID) throws JobServicesException {
		return jobCounselServiceCore.searchJobs(searchQuery, sectorID);
	}

	@Override
	public Boolean saveUserSubscription(String emailId) throws JobServicesException {
		return jobCounselServiceCore.saveUserSubscription(emailId);
	}
	
	@Override
	public String confirmEmailGUID(String confirmationEmailGUID) throws JobServicesException{
		return jobCounselServiceCore.confirmEmailGUID(confirmationEmailGUID);
	}
	
	@Override
	public String unsubscribeEmail(String unsubscribeId) throws JobServicesException{
		return jobCounselServiceCore.unsubscribeEmail(unsubscribeId);
	}

	@Override
	public Boolean jobNotifications() throws JobServicesException {
		return jobCounselServiceCore.sendJobNotificationToSubscribers();
	}

	@Override
	public List<LatestJobNotificationResp> jobMessages() throws JobServicesException {
		return jobCounselServiceCore.jobMessages();
	}

	@Override
	public HiringOrgResponse hiringOrganizations(String sectorId) throws JobServicesException {
		return jobCounselServiceCore.hiringOrganizations(sectorId);
	}

	@Override
	public List<Job> getAllJobsForOrg(Long orgId) throws JobServicesException {
		return jobCounselServiceCore.getAllJobsForOrg(orgId);
	}

}
