package in.jobcounsel.services.db.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
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

	// TODO: Implement Logging And Exception
	@PersistenceContext
	private EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	private static final String GETALLJOBSBYCATEGORY = "SELECT job  from Job job where job.branchid.id = :category";
	private static final String GETALLJOBSCOUNT = "select COUNT (job.qualification) from Job job";
	private static final String GETDETAILEDJOBINFOFROMDB = "SELECT job  from Job job where job.id in (:jobIds)";

	Logger logger = LoggerFactory.getLogger(DataAccessImpl.class);

	public Long getAllJobs() {
		Query query = entityManager.createQuery(GETALLJOBSCOUNT);
		try {
			Long totalCount = (Long) query.getSingleResult();
			return totalCount;
		} catch (Exception e) {
			logger.error("Exception While Retriving All Jobs Count Message:{}", e.getLocalizedMessage());
		}
		return 0L;
	}

	public List<Job> getAllJobsByCategory(Integer category) {
		List<Job> jobs = new ArrayList<>();
		try {
			Query query = entityManager.createQuery(GETALLJOBSBYCATEGORY, Job.class);
			query.setParameter("category", category.intValue());

			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method GETALLJOBSBYCATEGORY");
		}

		return jobs;
	}

	public List<Job> getAllJobsByCategoryIdAndType(Integer categoryId, Integer typeId) {
		Query query = entityManager.createQuery("select job from Job job", Job.class);

		List<Job> jobs = query.getResultList();

		return jobs;
	}

	public List<Job> getJobDetail(List<Long> jobIds) {
		List<Job> jobs = new ArrayList<>();
		List<Integer> jobReqAsInt = jobIds.stream()
		           .map(Long::intValue).collect(Collectors.toList());
		           
		try {
			Query query = entityManager.createQuery(GETDETAILEDJOBINFOFROMDB, Job.class);
			query.setParameter("jobIds", jobReqAsInt);

			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method GETJOBDetail");
		}

		return jobs;
	}

	public List<Sector> getAllSectors() {
		Query query = entityManager.createQuery("select sector from Sector sector", Sector.class);

		List<Sector> allSector = query.getResultList();

		return allSector;

	}

	public List<Branch> getAllBranches() {
		Query query = entityManager.createQuery("select branch from Branch branch", Branch.class);

		List<Branch> allBranches = query.getResultList();

		return allBranches;

	}

	public List<Organization> getAllOraganizations() {
		Query query = entityManager.createQuery("select org from Organization org", Organization.class);

		List<Organization> allOrganizations = query.getResultList();

		return allOrganizations;
	}

	@Override
	public Job saveJob(Job job) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(job);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception While Saving Job Message: {}", e.getLocalizedMessage());
			return null;
		}
		return job;
	}

}
