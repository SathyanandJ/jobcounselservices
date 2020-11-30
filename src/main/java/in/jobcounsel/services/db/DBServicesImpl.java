package in.jobcounsel.services.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.jobcounsel.services.db.core.DataAccess;
import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

@Service
public class DBServicesImpl implements DBServices {

	@Autowired
	DataAccess dataAccess;

	public List<Job> getAllJobsBySector(int sectorId) {
		List<Job> allJobsByCategory = dataAccess.getAllJobsBySector(sectorId);
		return allJobsByCategory;
	}

	public Long getAllJobsCount() {
		Long totalCount = dataAccess.getAllJobs();
		return totalCount;
	}

	public List<Job> getAllJobsBySectorAndBranch(int sectorId, int branchId) {
		List<Job> allJobsByCategoryAndType = dataAccess.getAllJobsBySectorAndBranch(sectorId, branchId);
		return allJobsByCategoryAndType;
	}

	public List<Job> getJobDetail(List<Long> jobIds) {
		List<Job> jobDetail = dataAccess.getJobDetail(jobIds);
		return jobDetail;
	}

	public List<Sector> getAllSectors() {
		List<Sector> allSectors = dataAccess.getAllSectors();
		return allSectors;
	}

	public List<Branch> getAllBranches() {
		List<Branch> allBranches = dataAccess.getAllBranches();
		return allBranches;
	}

	public List<Organization> getAllOrganization() {
		List<Organization> allOrganizations = dataAccess.getAllOraganizations();
		return allOrganizations;
	}

	@Override
	@Transactional
	public Job saveJob(Job job) {
		Job savedJob = dataAccess.saveJob(job);
		return savedJob;
	}

	@Override
	public List<Job> getJobsById(List<Long> jobIds) {
		List<Job> jobs = dataAccess.getJobsById(jobIds);
		return jobs;
	}

	@Override
	public List<Job> getJobsByIdAndSectorId(List<Long> jobIds, Long sectorID) {
		List<Job> jobs = dataAccess.getJobsByIdAndSectorId(jobIds,sectorID);
		return jobs;
	}

}
