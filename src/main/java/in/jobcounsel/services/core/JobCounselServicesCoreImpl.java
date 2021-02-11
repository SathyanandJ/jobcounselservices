package in.jobcounsel.services.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.core.buiness.sorter.SortJobs;
import in.jobcounsel.services.core.cache.AppServicesCache;
import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.core.search.DataSearchOperations;
import in.jobcounsel.services.core.search.lucene.DataSearchOperationsLucene;
import in.jobcounsel.services.db.DBServices;
import in.jobcounsel.services.db.entities.EmailSubscription;
import in.jobcounsel.services.email.EmailServices;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.HiringOrgResponse;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobCount;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.response.JobMessage;
import in.jobcounsel.services.response.LatestJobNotificationResp;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.OrganizationsHiring;
import in.jobcounsel.services.response.Sector;
import in.jobcounsel.services.utility.AppUtility;

@Service
public class JobCounselServicesCoreImpl implements JobCounselServicesCore {

	@Autowired
	DBServices dbServices;

	@Autowired
	AppServicesCache cacheService;

	@Autowired
	JobsCoreBusinessHelper coreBusinessHelper;

	@Autowired
	DataSearchOperations dataSearch;

	@Autowired
	SortJobs sortJobsHelper;

	@Autowired
	EmailServices emailService;

	@Value("${application.notification.filelocation}")
	private String jobFileName;
	
	private static final Logger logger = LoggerFactory.getLogger(JobCounselServicesCoreImpl.class);

	@Override
	public JobCount getAllJobsCount() throws JobServicesException {
		Long currentLiveJobsCount = dbServices.getAllJobsCount();
		JobCount jobCount = new JobCount();
		jobCount.setTotalJobs(currentLiveJobsCount);
		return jobCount;
	}

	@Override
	public List<Job> getAllJobsBySector(Integer sectorId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> allJobsBySector = dbServices.getAllJobsBySector(sectorId);
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
				.convertDBJobListToCoreServiceList(allJobsBySector);

		List<JobCoreModel> sortedJobs = sortJobsHelper.sortJobsNextExpiryFirst(convertedJobCoreObjectList);

		List<Job> convertedJobList = coreBusinessHelper.extractJobDataFromDB(sortedJobs);
		return convertedJobList;
	}

	@Override
	public List<Job> getAllJobsBySectorAndBranch(Integer sectorId, Integer branchId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> getAllJobsByCategoryAndType = new ArrayList<>();
		if (branchId != 0)
			getAllJobsByCategoryAndType = dbServices.getAllJobsBySectorAndBranch(sectorId, branchId);
		else
			getAllJobsByCategoryAndType = dbServices.getAllJobsBySector(sectorId);
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
				.convertDBJobListToCoreServiceList(getAllJobsByCategoryAndType);
		List<JobCoreModel> sortedJobs = sortJobsHelper.sortJobsNextExpiryFirst(convertedJobCoreObjectList);
		List<Job> convertedJobList = coreBusinessHelper.extractJobDataFromDB(sortedJobs);
		return convertedJobList;
	}

	@Override
	public JobDetail getJobDetails(Long jobId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> jobDBData = dbServices.getJobDetail(Arrays.asList(jobId));
		if (jobDBData != null && !jobDBData.isEmpty()) {
			List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
					.convertDBJobListToCoreServiceList(jobDBData);
			List<JobDetail> jobDetail = coreBusinessHelper.extractFullJobDataFromDB(convertedJobCoreObjectList);
			if (null != jobDetail && jobDetail.size() > 0)
				return jobDetail.get(0);
		}
		return new JobDetail();
	}

	@Override
	public List<Sector> getAllSectors() throws JobServicesException {
		if (cacheService.isSectorCached()) {
			return cacheService.getAllSectorFromCache();
		} else {
			List<in.jobcounsel.services.db.entities.Sector> allSectors = dbServices.getAllSectors();
			if (allSectors != null) {
				List<Sector> allServiceSectors = DataTypeConvertor.convertDBSectorListToServiceSectorList(allSectors);
				if (allServiceSectors != null && !allServiceSectors.isEmpty()) {
					cacheService.addAllSectorsToCache(allServiceSectors);
					return allServiceSectors;
				}
			}
		}
		return new ArrayList<Sector>();

	}

	@Override
	public List<Branch> getAllBranches() throws JobServicesException {
		if (cacheService.isBranchesCached()) {
			return cacheService.getAllBranchFromCache();
		} else {
			List<in.jobcounsel.services.db.entities.Branch> allBranches = dbServices.getAllBranches();
			if (allBranches != null) {
				List<Branch> allServiceBranches = DataTypeConvertor.convertDBBranchListToServiceBranchList(allBranches);
				if (allServiceBranches != null && !allServiceBranches.isEmpty()) {
					cacheService.addAllBranchToCache(allServiceBranches);
					return allServiceBranches;
				}
			}
		}
		return new ArrayList<Branch>();
	}

	@Override
	public List<Organization> getAllOrganization() throws JobServicesException {
		if (cacheService.isOrganizationCached())
			return cacheService.getAllOrganizationsFromCache();
		else {
			List<in.jobcounsel.services.db.entities.Organization> allOrganization = dbServices.getAllOrganization();
			if (allOrganization != null) {
				List<Organization> allServiceOrganization = DataTypeConvertor
						.convertDBOrgListToServiceOrgList(allOrganization);
				if (allServiceOrganization != null && !allServiceOrganization.isEmpty()) {
					cacheService.addAllOrganizationsToCache(allServiceOrganization);
					return allServiceOrganization;
				}
			}
		}
		return new ArrayList<Organization>();
	}

	@Override
	public Job saveJob(JobReq jobReq) throws JobServicesException {
		List<Branch> allBranchs = getAllBranches();
		List<Organization> allOrganization = getAllOrganization();
		in.jobcounsel.services.db.entities.Job job = dbServices
				.saveJob(DataTypeConvertor.convertJobReqToJob(jobReq, allBranchs, allOrganization));
		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
				.convertDBJobListToCoreServiceList(Arrays.asList(job));
		List<Job> jobData = coreBusinessHelper.extractJobDataFromDB(convertedJobCoreObjectList);
		if (jobData != null && !jobData.isEmpty())
			return jobData.get(0);
		else
			return new Job();
	}

	@Override
	public List<Job> searchJobs(String searchQuery, Long sectorID) throws JobServicesException {
		if (!AppUtility.isStringAlphaNumeric(searchQuery))
			throw new JobServicesException("Invalid Query String Entered", "JOB_SEARCH_INVALID_QUERY");

		searchQuery = AppUtility.filterToAlphaNumericCharacters(searchQuery);

		List<Long> jobIds = dataSearch.searchDataInIndex(searchQuery, sectorID.intValue());
		List<in.jobcounsel.services.db.entities.Job> searchResultJobs = dbServices.getJobsById(jobIds);
		List<JobCoreModel> searchJobResultList = DataTypeConvertor.convertDBJobListToCoreServiceList(searchResultJobs);
		List<Job> searchResultconvertedJobList = coreBusinessHelper.extractJobDataFromDB(searchJobResultList);
		return searchResultconvertedJobList;
	}

	@Override
	public Boolean saveUserSubscription(String emailId) throws JobServicesException {
		// TODO: Check IF Email already Added and if so already subscribed send back a
		// notification that user already added
		Boolean isEmailValid = AppUtility.isEmailValid(emailId);
		Boolean result = false;
		if (isEmailValid) {
			String guidForEmail = AppUtility.generateGUIDForEmail();
			char emailVerified = 'F';
			char subscriptionStatus = 'T';

			EmailSubscription emailSub = DataTypeConvertor.createEmailSubscriptionDBObj(emailId, guidForEmail,
					emailVerified, subscriptionStatus);

			emailSub = dbServices.saveEmailSubscription(emailSub);

			if (emailSub != null) {
				result = true;
				String generatedGUID = emailSub.getId() + "__" + guidForEmail;
				CompletableFuture.runAsync(() -> {
					emailService.sendEmailConfirmationLink(emailId, generatedGUID);
				});
			}
		} else {
			throw new JobServicesException("Invalid Email Cannot Process", "1001");
		}
		return result;
	}

	@Override
	public String confirmEmailGUID(String confirmationEmailGUID) throws JobServicesException {
		String[] guidSplit = confirmationEmailGUID.split("__");
		String emailIdentifier = "";
		String guidIdentifier = "";
		Boolean guidValid = false;
		if (guidSplit.length == 2) {
			emailIdentifier = guidSplit[0];
			guidIdentifier = guidSplit[1];
		}
		Boolean isValidIdentifier = StringUtils.isNumeric(emailIdentifier);
		EmailSubscription emailSub = null;
		if (isValidIdentifier) {
			emailSub = dbServices.getEmailSubscription(Integer.parseInt(emailIdentifier));
		} else {
			throw new JobServicesException("Invalid Email Message Identifier", "10002");
		}
		if (emailSub != null) {
			String guidFromDB = emailSub.getEmailguid();
			if (null != guidFromDB && guidFromDB.equals(guidIdentifier)) {
				guidValid = true;
			} else {
				throw new JobServicesException("Corrupted Message Identifier", "10003");
			}
		}
		if (guidValid) {
			emailSub.setIsEmailVerified('T');
			dbServices.updateEmailSubscription(emailSub);
		} else {
			throw new JobServicesException("Invalid GUID Found. Unable To Verify Email Id", "10004");
		}
		return "Success !! Email Verified Successfully";
	}

	@Override
	public String unsubscribeEmail(String unsubscribeId) throws JobServicesException {
		String[] guidSplit = unsubscribeId.split("__");
		String emailIdentifier = "";
		String guidIdentifier = "";
		Boolean guidValid = false;
		if (guidSplit.length == 2) {
			emailIdentifier = guidSplit[0];
			guidIdentifier = guidSplit[1];
		}
		Boolean isValidIdentifier = StringUtils.isNumeric(emailIdentifier);
		EmailSubscription emailSub = null;
		if (isValidIdentifier) {
			emailSub = dbServices.getEmailSubscription(Integer.parseInt(emailIdentifier));
		} else {
			throw new JobServicesException("Invalid Email Message Identifier", "10002");
		}
		if (emailSub != null) {
			String guidFromDB = emailSub.getEmailguid();
			if (null != guidFromDB && guidFromDB.equals(guidIdentifier)) {
				guidValid = true;
			} else {
				throw new JobServicesException("Corrupted Message Identifier", "10003");
			}
		}
		if (guidValid) {
			emailSub.setIsSubscribed('F');
			dbServices.updateEmailSubscription(emailSub);
		} else {
			throw new JobServicesException("Invalid GUID Found. Unable To Verify Email Id", "10004");
		}
		return "Email UnSubscription Successful";
	}

	@Override
	public Boolean sendJobNotificationToSubscribers() throws JobServicesException {
		Boolean mailNotification = false;
		// Step 1 Generate the Job Notification PDF
		// Get The List of Active Jobs
		List<in.jobcounsel.services.db.entities.Job> allActiveJobs = dbServices.getAllActiveJobs();

		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
				.convertDBJobListToCoreServiceList(allActiveJobs);

		// Phase II Sort it by Experience requirement

		// Write the list of Jobs onto the PDF

		Boolean pdfGenerated = coreBusinessHelper.createPDFWithJobData(convertedJobCoreObjectList, jobFileName);

		if (pdfGenerated) {
			mailNotification = true;
			// Code To Send the PDF Via Mail

			List<EmailSubscription> emailSubscriptions = dbServices.getAllEmailSubscriptions();

			List<in.jobcounsel.services.core.models.EmailSubscriptionCore> convertedEmailCoreObjs = DataTypeConvertor
					.convertDBEmailSubListToCoreServiceList(emailSubscriptions);

			List<in.jobcounsel.services.core.models.EmailSubscriptionCore> validEmailToSendNotification = convertedEmailCoreObjs
					.stream().filter(subscription -> subscription.getIsEmailVerified() == 'T'
							&& subscription.getIsSubscribed() == 'T')
					.collect(Collectors.toList());

			CompletableFuture.runAsync(() -> {
				emailService.sendJobNotificationToSubscribers(validEmailToSendNotification, jobFileName);
			});

		}

		return mailNotification;
	}

	@Override
	public List<LatestJobNotificationResp> jobMessages() throws JobServicesException {
		// Get All Active Jobs
		List<in.jobcounsel.services.db.entities.Job> allActiveJobs = dbServices.getAllActiveJobs();

		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor
				.convertDBJobListToCoreServiceList(allActiveJobs);

		// Break into 3 Sectors

		List<String> governmentSectorJobs = new ArrayList<>();
		List<String> publicSectorJobs = new ArrayList<>();
		List<String> stateGovernmentJobs = new ArrayList<>();

		Map<String, Integer> orgVacancies = new HashMap<>();

		for (in.jobcounsel.services.db.entities.Job job : allActiveJobs) {
			if (job.getOrgid().getSectorId().getId() == 1) {
				governmentSectorJobs.add(job.getOrgid().getName());
			} else if (job.getOrgid().getSectorId().getId() == 2) {
				publicSectorJobs.add(job.getOrgid().getName());
			} else {
				stateGovernmentJobs.add(job.getOrgid().getName());
			}
			String orgName = job.getOrgid().getName();
			if (orgVacancies.containsKey(orgName)) {
				Integer vacancies = orgVacancies.get(orgName);

				vacancies += job.getTotalVacancies();

				orgVacancies.put(orgName, vacancies);
			} else {
				orgVacancies.put(orgName, job.getTotalVacancies());
			}
		}

		// Group the Total Vacancies by org for each Sector

		// Take the top 20

		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(orgVacancies.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		// Take the Top 20 and Pack it in the correct order
		Set<String> sortedJobs = temp.keySet();

		List<JobMessage> govTopOrg = new ArrayList<>();
		List<JobMessage> publicSecTopOrg = new ArrayList<>();
		List<JobMessage> stateTopOrg = new ArrayList<>();

		List<Organization> allOrganization = getAllOrganization();
		
		Map<String, Long> mapOrgNameToOrgId = new HashMap<>();

		try {
		mapOrgNameToOrgId = allOrganization.stream()
				.collect(Collectors.toMap(Organization::getName,Organization::getId));
		}catch(Throwable t) {
			logger.error("Error  Occured While Converting Error Message : {}",t.getLocalizedMessage());
		}
		
		for (String orgName : sortedJobs) {
			Integer totalVacancies = temp.get(orgName);
			JobMessage jobMessage = new JobMessage();
			jobMessage.setOrgId(mapOrgNameToOrgId.get(orgName).intValue());
			jobMessage.setOrganization(orgName);
			jobMessage.setVacancies(totalVacancies);
			if (totalVacancies > 0) {
				if (governmentSectorJobs.contains(orgName) && govTopOrg.size() <= 20) {
					govTopOrg.add(jobMessage);
				} else if (publicSectorJobs.contains(orgName) && publicSecTopOrg.size() <= 20) {
					publicSecTopOrg.add(jobMessage);
				} else if (stateTopOrg.size() <= 20) {
					stateTopOrg.add(jobMessage);
				}
			}
		}

		// Build The Final Message
		List<LatestJobNotificationResp> responseList = new ArrayList<>();
		
		
		
		//StringBuilder responseStr = new StringBuilder();
		
		

		if (govTopOrg.size() > 0) {
			//responseStr.append("Government Organizations:");

			for (JobMessage msg : govTopOrg) {
				LatestJobNotificationResp jobNotify = new LatestJobNotificationResp();
				jobNotify.setJobId(msg.getOrgId());
				jobNotify.setOrgWithVacancies(msg.getOrganization() + "(" + msg.getVacancies() + " Vacancies)");
				responseList.add(jobNotify);
			}
		}

		if (publicSecTopOrg.size() > 0) {
			//responseStr.append("Public Sector Organizations:");

			for (JobMessage msg : publicSecTopOrg) {
				LatestJobNotificationResp jobNotify = new LatestJobNotificationResp();
				jobNotify.setJobId(msg.getOrgId());
				jobNotify.setOrgWithVacancies(msg.getOrganization() + "(" + msg.getVacancies() + " Vacancies)");
				responseList.add(jobNotify);
			}
		}

		if (stateTopOrg.size() > 0) {
			//responseStr.append("State Government Organizations:");

			for (JobMessage msg : stateTopOrg) {
				LatestJobNotificationResp jobNotify = new LatestJobNotificationResp();
				jobNotify.setJobId(msg.getOrgId());
				jobNotify.setOrgWithVacancies(msg.getOrganization() + "(" + msg.getVacancies() + " Vacancies)");
				responseList.add(jobNotify);
			}
		}
		// Group By Sector and Take top 20<<configurable>>

		return responseList;
	}

	@Override
	public HiringOrgResponse hiringOrganizations(String sectorId) throws JobServicesException {
		HiringOrgResponse response = new HiringOrgResponse();
		List<Organization> allOrganization = getAllOrganization();

		Map<String, Long> mapOrgToSector = new HashMap<>();

		mapOrgToSector = allOrganization.parallelStream()
				.collect(Collectors.toMap(Organization::getName, org -> org.getSector().getId()));

		Map<String, Long> mapOrgNameToOrgId = new HashMap<>();

		mapOrgNameToOrgId = allOrganization.parallelStream()
				.collect(Collectors.toMap(Organization::getName, Organization::getId));

		List<in.jobcounsel.services.db.entities.Job> allActiveJobs = dbServices.getAllActiveJobs();

		Map<String, JobCoreModel> activeJobByName = new HashMap<>();

		List<JobCoreModel> convertedActiveJobsList = DataTypeConvertor.convertDBJobListToCoreServiceList(allActiveJobs);

		activeJobByName = convertedActiveJobsList.parallelStream()
				.collect(Collectors.toMap(JobCoreModel::getOrganizationName, jobCoreModel -> jobCoreModel));

		List<String> governmentSectorJobs = new ArrayList<>();
		List<String> publicSectorJobs = new ArrayList<>();
		List<String> stateGovernmentJobs = new ArrayList<>();

		Map<String, Integer> orgVacancies = new HashMap<>();

		for (in.jobcounsel.services.db.entities.Job job : allActiveJobs) {
			if (job.getOrgid().getSectorId().getId() == 1) {
				governmentSectorJobs.add(job.getOrgid().getName());
			} else if (job.getOrgid().getSectorId().getId() == 2) {
				publicSectorJobs.add(job.getOrgid().getName());
			} else {
				stateGovernmentJobs.add(job.getOrgid().getName());
			}
			String orgName = job.getOrgid().getName();
			if (orgVacancies.containsKey(orgName)) {
				Integer vacancies = orgVacancies.get(orgName);

				vacancies += job.getTotalVacancies();

				orgVacancies.put(orgName, vacancies);
			} else {
				orgVacancies.put(orgName, job.getTotalVacancies());
			}
		}

		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(orgVacancies.entrySet());

		// Sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		Set<String> sortedJobs = temp.keySet();

		List<OrganizationsHiring> govSectorList = new ArrayList<>();
		List<OrganizationsHiring> publicSectorList = new ArrayList<>();
		List<OrganizationsHiring> stateGovSectorList = new ArrayList<>();

		for (String orgName : sortedJobs) {
			Long sectorIdForOrg = mapOrgToSector.get(orgName);
			Integer vacancies = orgVacancies.get(orgName);
			Long orgId = mapOrgNameToOrgId.get(orgName);

			OrganizationsHiring orgHiring = new OrganizationsHiring(orgId.intValue(), orgName, vacancies,
					sectorIdForOrg);

			if (sectorId.equals("1")) {
				govSectorList.add(orgHiring);
			} else if (sectorId.equals("2")) {
				publicSectorList.add(orgHiring);
			} else {
				stateGovSectorList.add(orgHiring);
			}
		}

		Map<Integer, List<OrganizationsHiring>> resultInObj = new HashMap<Integer, List<OrganizationsHiring>>();

		resultInObj.put(1, govSectorList);
		resultInObj.put(2, publicSectorList);
		resultInObj.put(3, stateGovSectorList);

		response.setOrgHiring(resultInObj);

		return response;
	}

	@Override
	public List<Job> getAllJobsForOrg(Long orgId) throws JobServicesException {
		List<in.jobcounsel.services.db.entities.Job> jobsForOrg = dbServices.getAllJobsByOrgId(orgId.intValue());

		List<JobCoreModel> convertedJobCoreObjectList = DataTypeConvertor.convertDBJobListToCoreServiceList(jobsForOrg);

		List<Job> convertedJobList = coreBusinessHelper.extractJobDataFromDB(convertedJobCoreObjectList);

		return convertedJobList;
	}
}
