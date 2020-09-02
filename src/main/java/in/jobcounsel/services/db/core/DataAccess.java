package in.jobcounsel.services.db.core;

import java.util.List;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

public interface DataAccess {
	
	public Long getAllJobs();
	
	public List<Job> getAllJobsByCategory(Integer category);
	
	public List<Job> getAllJobsByCategoryIdAndType(Integer categoryId,Integer typeId);
	
	public Job getJobDetail(Long jobId);
	
	public List<Sector> getAllSectors();
	
	public List<Branch> getAllBranches();
	
	public List<Organization> getAllOraganizations();

}
