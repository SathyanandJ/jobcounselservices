package in.jobcounsel.services.db.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import in.jobcounsel.services.db.entities.Branch;
import in.jobcounsel.services.db.entities.EmailSubscription;
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

	private static final String GETALLJOBSBYSECTOR = "SELECT job  from Job job where job.orgid.sectorId.id = :sector";
	private static final String GETALLJOBSBYSECTORANDBRANCH = "SELECT job  from Job job where job.orgid.sectorId.id = :sector AND job.branchid.id =:branch";
	private static final String GETALLJOBSCOUNT = "select SUM(job.totalVacancies) as TotalJobs from Job job";
	private static final String GETDETAILEDJOBINFOFROMDB = "SELECT job  from Job job where job.id in (:jobIds)";
	private static final String GETALLJOBSBYID = "SELECT job  from Job job where job.id in (:jobids)";
	private static final String GETALLJOBSBYIDANDSECTORID = "SELECT job  from Job job where job.orgid.sectorId.id = :sector AND job.id in (:jobids)";
	private static final String GETEMAILSUBSCRIPTIONBYID = "SELECT esub from EmailSubscription esub where esub.id =:subid";
	private static final String GETALLEMAILSUBSCRIPTIONS = "SELECT esub from EmailSubscription esub";
	private static final String GETALLJOBSACTIVEJOBS = "SELECT job  from Job job where job.jobApplyLastDate > CURRENT_TIMESTAMP";
	private static final String GETALLJOBSBYORGANIZATION = "SELECT job  from Job job where job.orgid.id = :orgid";
	

	Logger logger = LoggerFactory.getLogger(DataAccessImpl.class);

	public Long getAllJobs() {
		Query query = entityManager.createQuery(GETALLJOBSCOUNT, Long.class);
		try {
			Long totalCount = (Long) query.getSingleResult();
			return totalCount;
		} catch (Exception e) {
			logger.error("Exception While Retriving All Jobs Count Message:{}", e.getLocalizedMessage());
		}
		return 0L;
	}

	public List<Job> getAllJobsBySector(Integer sectorId) {
		List<Job> jobs = new ArrayList<>();
		try {
			Query query = entityManager.createQuery(GETALLJOBSBYSECTOR, Job.class);
			query.setParameter("sector", sectorId.intValue());

			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method GETALLJOBSBYSECTOR Error Message : {}",
					e.getLocalizedMessage());
		}

		return jobs;
	}

	public List<Job> getAllJobsBySectorAndBranch(Integer sectorId, Integer branchId) {
		List<Job> jobs = new ArrayList<>();
		try {
			Query query = entityManager.createQuery(GETALLJOBSBYSECTORANDBRANCH, Job.class);
			query.setParameter("sector", sectorId.intValue());
			query.setParameter("branch", branchId.intValue());
			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method getAllJobsBySectorAndBranch Error Message : {}",
					e.getLocalizedMessage());
		}
		return jobs;
	}

	public List<Job> getJobDetail(List<Long> jobIds) {
		List<Job> jobs = new ArrayList<>();
		List<Integer> jobReqAsInt = jobIds.stream().map(Long::intValue).collect(Collectors.toList());

		try {
			Query query = entityManager.createQuery(GETDETAILEDJOBINFOFROMDB, Job.class);
			query.setParameter("jobIds", jobReqAsInt);

			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method GETJOBDetail Error Message : {}",
					e.getLocalizedMessage());
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

	@Override
	public List<Job> getJobsById(List<Long> jobIds) {
		List<Job> jobs = new ArrayList<>();
		List<Integer> jobIDsAsInt = jobIds.stream().map(Long::intValue).collect(Collectors.toList());
		try {
			Query query = entityManager.createQuery(GETALLJOBSBYID, Job.class);
			query.setParameter("jobids", jobIDsAsInt);
			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method getJobsById Error Message : {}",
					e.getLocalizedMessage());
		}
		return jobs;
	}

	@Override
	public List<Job> getJobsByIdAndSectorId(List<Long> jobIds, Long sectorID) {
		List<Job> jobs = new ArrayList<>();
		List<Integer> jobIDsAsInt = jobIds.stream().map(Long::intValue).collect(Collectors.toList());
		try {
			Query query = entityManager.createQuery(GETALLJOBSBYIDANDSECTORID, Job.class);
			query.setParameter("sector", sectorID.intValue());
			query.setParameter("jobids", jobIDsAsInt);
			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method getJobsById Error Message : {}",
					e.getLocalizedMessage());
		}
		return jobs;
	}

	@Override
	public EmailSubscription getEmailSubscription(Integer subscriptionId) {
		EmailSubscription subscription = new EmailSubscription();
		try {
			Query query = entityManager.createQuery(GETEMAILSUBSCRIPTIONBYID, EmailSubscription.class);
			query.setParameter("subid", subscriptionId);
			List<EmailSubscription> subList = query.getResultList();
			if (subList != null && !subList.isEmpty())
				subscription = subList.get(0);
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method getEmailSubscription Error Message : {}",
					e.getLocalizedMessage());
		}
		return subscription;
	}

	@Override
	public EmailSubscription saveEmailSubscription(EmailSubscription subscription) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(subscription);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception While Saving Job Message: {}", e.getLocalizedMessage());
			return null;
		}
		return subscription;
	}

	@Override
	public EmailSubscription updateEmailSubscription(EmailSubscription subscription) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			subscription = entityManager.merge(subscription);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			logger.error("Exception While Saving Job Message: {}", e.getLocalizedMessage());
			return null;
		}
		return subscription;
	}

	@Override
	public List<EmailSubscription> getAllEmailSubscriptions() {
		Query query = entityManager.createQuery(GETALLEMAILSUBSCRIPTIONS, EmailSubscription.class);

		List<EmailSubscription> allSubscriptions = query.getResultList();

		return allSubscriptions;
	}

	@Override
	public List<Job> getAllActiveJobs() {
		Query query = entityManager.createQuery(GETALLJOBSACTIVEJOBS, Job.class);

		List<Job> allActiveJobs = query.getResultList();

		return allActiveJobs;
	}

	@Override
	public List<Job> getAllJobsByOrg(Integer orgId) {
		List<Job> jobs = new ArrayList<>();
		try {
			TypedQuery<Job> query = entityManager.createQuery(GETALLJOBSBYORGANIZATION, Job.class);
			query.setParameter("orgid", orgId);

			jobs = query.getResultList();
		} catch (Exception e) {
			logger.error("Exception While Calling DB In Method GETALLJOBSBYORGANIZATION Error Message : {}",
					e.getLocalizedMessage());
		}

		return jobs;
	}

}
