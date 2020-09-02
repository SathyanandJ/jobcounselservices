package in.jobcounsel.services.db;

import java.util.List;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

public interface DBServices {
	
	public List<Job> getAllJobsByCategory(int categoryId);
	
	public Long getAllJobsCount();
	
	public List<Job> getAllJobsByCategoryAndType(int categoryId,long typeId);
	
	public Job getJobDetail(Long jobId);
	
	public List<Sector> getAllSectors();
	
	public List<Branch> getAllBranches();
	
	public List<Organization> getAllOrganization();

}
