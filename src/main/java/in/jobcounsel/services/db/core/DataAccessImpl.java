package in.jobcounsel.services.db.core;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.Job;
import in.jobcounsel.services.db.entities.Organization;
import in.jobcounsel.services.db.entities.Sector;

@Repository
public class DataAccessImpl implements DataAccess {

	//TODO: Implement Logging And Exception
	@PersistenceContext
	private EntityManager entityManager;

	Logger logger = LoggerFactory.getLogger(DataAccessImpl.class);

	public Long getAllJobs() {
		Query query = entityManager.createQuery("select COUNT (job.qualification) from Job job");

		Long totalCount = (Long) query.getSingleResult();

		return totalCount;
	}

	public List<Job> getAllJobsByCategory(Integer category) {
		Query query = entityManager.createQuery("select job from Job job", Job.class);

		List<Job> jobs = query.getResultList();

		return jobs;
	}
	
	public List<Job> getAllJobsByCategoryIdAndType(Integer categoryId,Integer typeId){
		Query query = entityManager.createQuery("select job from Job job", Job.class);

		List<Job> jobs = query.getResultList();

		return jobs;
	}
	
	
	public Job getJobDetail(Long jobId){
		Query query = entityManager.createQuery("select job from Job job", Job.class);

		List<Job> job = query.getResultList();

		if(job!=null && job.size()>0)
			return job.get(0);
		else
			return null;
	}
	
	public List<Sector> getAllSectors() {
		Query query = entityManager.createQuery("select sector from Sector sector", Sector.class);
		
		List<Sector> allSector = query.getResultList();
		
		return allSector;
		
	}
	
	public List<Branch> getAllBranches(){
		Query query = entityManager.createQuery("select branch from Branch branch", Branch.class);
		
		List<Branch> allBranches = query.getResultList();
		
		return allBranches;
		
	}
	
	public List<Organization> getAllOraganizations(){
		Query query = entityManager.createQuery("select org from Organization org", Organization.class);
		
		List<Organization> allOrganizations = query.getResultList();
		
		return allOrganizations;
	}

}
