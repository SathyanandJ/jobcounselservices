package in.jobcounsel.services.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.db.DBServices;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@Service
public class JobCounselServicesCoreImpl implements JobCounselServicesCore {

	@Autowired
	DBServices dbServices;

	@Override
	public JobCount getAllJobsCount() throws JobServicesException {
		Long currentLiveJobsCount = dbServices.getAllJobsCount();
		JobCount jobCount = new JobCount();
		jobCount.setTotalJobs(currentLiveJobsCount);
		return jobCount;
	}

	@Override
	public List<Job> getAllJobsByCategory(Integer categoryId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> getAllJobsByCategory = dbServices.getAllJobsByCategory(categoryId);
		List<Job> convertedJobList = DataTypeConvertor.convertDBListToServiceList(getAllJobsByCategory);
		return convertedJobList;
	}

	@Override
	public List<Job> getAllJobs(Integer categoryId, Integer typeId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> getAllJobsByCategoryAndType = dbServices
				.getAllJobsByCategory(categoryId);
		List<Job> convertedJobList = DataTypeConvertor.convertDBListToServiceList(getAllJobsByCategoryAndType);
		return convertedJobList;
	}

	@Override
	public Job getJobDetails(Long jobId) throws JobServicesException {
		in.jobcounsel.services.db.entities.Job jobDBData =  dbServices.getJobDetail(jobId);
		if(jobDBData!=null) {
			List<Job> jobDetail = DataTypeConvertor.convertDBListToServiceList(Arrays.asList(jobDBData));
			if(null!=jobDetail && jobDetail.size()>0)
				return jobDetail.get(0);
		}
		return new Job();
	}

	@Override
	public List<Sector> getAllSectors() throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Sector> allSectors = dbServices.getAllSectors();
		if(allSectors!=null) {
			List<Sector> allServiceSectors = DataTypeConvertor.convertDBSectorListToServiceSectorList(allSectors);
			if(allServiceSectors!=null && allServiceSectors.size() > 0)
				return allServiceSectors;
		}
		return new ArrayList<Sector>();
	
	}

	@Override
	public List<Branch> getAllBranches() throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Branch> allBranches = dbServices.getAllBranches();
		if(allBranches!=null) {
			List<Branch> allServiceBranches = DataTypeConvertor.convertDBBranchListToServiceBranchList(allBranches);
			if(allServiceBranches!=null && allServiceBranches.size() > 0)
				return allServiceBranches;
		}
		return new ArrayList<Branch>();
	}

	@Override
	public List<Organization> getAllOrganization() throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Organization> allOrganization = dbServices.getAllOrganization();
		if(allOrganization!=null) {
			List<Organization> allServiceOrganization = DataTypeConvertor.convertDBOrgListToServiceOrgList(allOrganization);
			if(allServiceOrganization!=null && allServiceOrganization.size() > 0)
				return allServiceOrganization;
		}
		return new ArrayList<Organization>();
	}
}
