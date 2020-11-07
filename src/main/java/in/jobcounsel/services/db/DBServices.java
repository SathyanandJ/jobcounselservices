package in.jobcounsel.services.db;

import java.util.List;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;
import in.jobcounsel.services.request.JobReq;

public interface DBServices {
	
	public List<Job> getAllJobsByCategory(int categoryId);
	
	public Long getAllJobsCount();
	
	public List<Job> getAllJobsByCategoryAndType(int categoryId,long typeId);
	
	public List<Job> getJobDetail(List<Long> jobIds);
	
	public List<Sector> getAllSectors();
	
	public List<Branch> getAllBranches();
	
	public List<Organization> getAllOrganization();
	
	public Job saveJob(Job job);

}
