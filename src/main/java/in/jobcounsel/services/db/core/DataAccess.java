package in.jobcounsel.services.db.core;

import java.util.List;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

public interface DataAccess {
	
	public Long getAllJobs();
	
	public List<Job> getAllJobsBySector(Integer sector);
	
	public List<Job> getAllJobsBySectorAndBranch(Integer sectorId,Integer branchId);
	
	public List<Job> getJobDetail(List<Long> jobIds);
	
	public List<Sector> getAllSectors();
	
	public List<Branch> getAllBranches();
	
	public List<Organization> getAllOraganizations();
	
	public Job saveJob(Job job);

	public List<Job> getJobsById(List<Long> jobIds);

}
