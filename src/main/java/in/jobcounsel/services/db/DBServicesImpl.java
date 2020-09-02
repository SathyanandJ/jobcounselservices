package in.jobcounsel.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jobcounsel.services.db.core.DataAccess;
import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

@Service
public class DBServicesImpl implements DBServices {

	@Autowired
	DataAccess dataAccess;

	public List<Job> getAllJobsByCategory(int categoryId) {
		List<Job> allJobsByCategory = dataAccess.getAllJobsByCategory(categoryId);
		return allJobsByCategory;
	}

	public Long getAllJobsCount() {
		Long totalCount = dataAccess.getAllJobs();
		return totalCount;
	}

	public List<Job> getAllJobsByCategoryAndType(int categoryId, long typeId) {
		List<Job> allJobsByCategoryAndType = dataAccess.getAllJobsByCategory(categoryId);
		return allJobsByCategoryAndType;
	}

	public Job getJobDetail(Long jobId) {
		Job jobDetail = dataAccess.getJobDetail(jobId);
		return jobDetail;
	}
	
	public List<Sector> getAllSectors(){
		List<Sector> allSectors = dataAccess.getAllSectors();
		return allSectors;
	}
	
	public List<Branch> getAllBranches(){
		List<Branch> allBranches = dataAccess.getAllBranches();
		return allBranches;
	}
	
	public List<Organization> getAllOrganization(){
		List<Organization> allOrganizations = dataAccess.getAllOraganizations();
		return allOrganizations;
	}

}
