package in.jobcounsel.services.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.core.cache.AppServicesCache;
import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.db.DBServices;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

@Service
public class JobCounselServicesCoreImpl implements JobCounselServicesCore {

	@Autowired
	DBServices dbServices;

	@Autowired
	AppServicesCache cacheService;
	
	@Autowired 
	JobsCoreBusinessHelper coreBusinessHelper;

	@Override
	public JobCount getAllJobsCount() throws JobServicesException {
		Long currentLiveJobsCount = dbServices.getAllJobsCount();
		JobCount jobCount = new JobCount();
		jobCount.setTotalJobs(currentLiveJobsCount);
		return jobCount;
	}

	@Override
	public List<Job> getAllJobsByCategory(Integer categoryId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> allJobsByCategory = dbServices.getAllJobsByCategory(categoryId);
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor.convertDBJobListToCoreServiceList(allJobsByCategory);
		List<Job> convertedJobList = coreBusinessHelper.extractJobDataFromDB(convertedJobCoreObjectList);
		return convertedJobList;
	}

	@Override
	public List<Job> getAllJobs(Integer categoryId, Integer typeId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> getAllJobsByCategoryAndType = dbServices
				.getAllJobsByCategory(categoryId);
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor.convertDBJobListToCoreServiceList(getAllJobsByCategoryAndType);
		List<Job> convertedJobList = coreBusinessHelper.extractJobDataFromDB(convertedJobCoreObjectList);
		return convertedJobList;
	}

	@Override
	public JobDetail getJobDetails(Long jobId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> jobDBData = dbServices.getJobDetail(Arrays.asList(jobId));
		if (jobDBData != null && !jobDBData.isEmpty()) {
			List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor.convertDBJobListToCoreServiceList(jobDBData);
			List<JobDetail> jobDetail = coreBusinessHelper.extractFullJobDataFromDB(convertedJobCoreObjectList);
			if (null != jobDetail && jobDetail.size() > 0)
				return jobDetail.get(0);
		}
		return new JobDetail();
	}

	@Override
	public List<Sector> getAllSectors() throws JobServicesException {
		if (cacheService.isSectorCached()) {
			return cacheService.getAllSectorFromCache();
		} else {
			List<in.jobcounsel.services.db.entities.Sector> allSectors = dbServices.getAllSectors();
			if (allSectors != null) {
				List<Sector> allServiceSectors = DataTypeConvertor.convertDBSectorListToServiceSectorList(allSectors);
				if (allServiceSectors != null && !allServiceSectors.isEmpty()) {
					cacheService.addAllSectorsToCache(allServiceSectors);
					return allServiceSectors;
				}
			}
		}
		return new ArrayList<Sector>();

	}

	@Override
	public List<Branch> getAllBranches() throws JobServicesException {
		if (cacheService.isBranchesCached()) {
			return cacheService.getAllBranchFromCache();
		} else {
			List<in.jobcounsel.services.db.entities.Branch> allBranches = dbServices.getAllBranches();
			if (allBranches != null) {
				List<Branch> allServiceBranches = DataTypeConvertor.convertDBBranchListToServiceBranchList(allBranches);
				if (allServiceBranches != null && !allServiceBranches.isEmpty()) {
					cacheService.addAllBranchToCache(allServiceBranches);
					return allServiceBranches;
				}
			}
		}
		return new ArrayList<Branch>();
	}

	@Override
	public List<Organization> getAllOrganization() throws JobServicesException {
		if (cacheService.isOrganizationCached())
			return cacheService.getAllOrganizationsFromCache();
		else {
			List<in.jobcounsel.services.db.entities.Organization> allOrganization = dbServices.getAllOrganization();
			if (allOrganization != null) {
				List<Organization> allServiceOrganization = DataTypeConvertor
						.convertDBOrgListToServiceOrgList(allOrganization);
				if (allServiceOrganization != null && !allServiceOrganization.isEmpty()) {
					cacheService.addAllOrganizationsToCache(allServiceOrganization);
					return allServiceOrganization;
				}
			}
		}
		return new ArrayList<Organization>();
	}

	@Override
	public Job saveJob(JobReq jobReq) throws JobServicesException {
		List<Branch> allBranchs = getAllBranches();
		List<Organization> allOrganization = getAllOrganization();
		in.jobcounsel.services.db.entities.Job job = dbServices.saveJob(DataTypeConvertor.convertJobReqToJob(jobReq, allBranchs, allOrganization));
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor.convertDBJobListToCoreServiceList(Arrays.asList(job));
		List<Job> jobData = coreBusinessHelper.extractJobDataFromDB(convertedJobCoreObjectList);
		if(jobData!=null && !jobData.isEmpty())
			return jobData.get(0);
		else
			return new Job();
	}

}
