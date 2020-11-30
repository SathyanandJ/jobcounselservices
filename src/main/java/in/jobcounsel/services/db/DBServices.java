package in.jobcounsel.services.db;

import java.util.List;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

public interface DBServices {
	
	public List<Job> getAllJobsBySector(int sectorId);
	
	public Long getAllJobsCount();
	
	public List<Job> getAllJobsBySectorAndBranch(int sectorId,int branchId);
	
	public List<Job> getJobDetail(List<Long> jobIds);
	
	public List<Sector> getAllSectors();
	
	public List<Branch> getAllBranches();
	
	public List<Organization> getAllOrganization();
	
	public Job saveJob(Job job);

	public List<Job> getJobsById(List<Long> jobIds);

	public List<Job> getJobsByIdAndSectorId(List<Long> jobIds, Long sectorID);

}
