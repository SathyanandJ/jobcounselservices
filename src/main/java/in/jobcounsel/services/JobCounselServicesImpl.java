package in.jobcounsel.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.core.JobCounselServicesCore;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.Organization;
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
	public List<Job> getAllJobsByCategory(Integer categoryId) throws JobServicesException {
		return jobCounselServiceCore.getAllJobsByCategory(categoryId);
	}

	@Override
	public  List<Job> getAllJobs(Integer categoryId, Integer typeId) throws JobServicesException {
		return jobCounselServiceCore.getAllJobs(categoryId, typeId);
	}

	@Override
	public Job getJobDetails(Long jobId) throws JobServicesException {
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

}
