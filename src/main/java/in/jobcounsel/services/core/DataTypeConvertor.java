package in.jobcounsel.services.core;

/**
 * @author Sathyanand Jebakumar
 * 
 * This class is to be used to convert all Entity Objects to Corresponding Service Objects
 * 
 */

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.request.JobReq;
import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;
import in.jobcounsel.services.utility.AppUtility;

public class DataTypeConvertor {

	public static List<JobCoreModel> convertDBJobListToCoreServiceList(
			List<in.jobcounsel.services.db.entities.Job> jobs) {
		List<JobCoreModel> convertedJobList = new ArrayList<JobCoreModel>();
		if (null != jobs && jobs.size() > 0) {
			convertedJobList = jobs.parallelStream()
					.map(dbJob -> new JobCoreModel(Long.valueOf(dbJob.getId()), dbJob.getOrgid().getName(),
							dbJob.getBranchid().getName(), dbJob.getSalaryID().getMinSalary(),
							dbJob.getSalaryID().getMaxSalary(), dbJob.getDesignation(), dbJob.getQualification(),
							dbJob.getDescription(), dbJob.getEligibilitycriteria(), dbJob.getJobLocation(),
							dbJob.getJobdetailslnk(), dbJob.getJobapplylnk(), dbJob.getJobApplyLastDate(),
							dbJob.getSelectionprocess(), dbJob.getTotalVacancies(), dbJob.getJobtype(), dbJob.getTags(),
							dbJob.getStamp_created()))
					.collect(Collectors.toList());

			return convertedJobList;
		}
		return convertedJobList;
	}

	public static List<Sector> convertDBSectorListToServiceSectorList(
			List<in.jobcounsel.services.db.entities.Sector> sector) {
		List<Sector> convertedSectorList = new ArrayList<Sector>();
		if (null != sector && sector.size() > 0) {
			convertedSectorList = sector.parallelStream().map(
					dbSector -> new Sector(Long.valueOf(dbSector.getId()), dbSector.getName(), dbSector.getTimeStamp()))
					.collect(Collectors.toList());

			return convertedSectorList;
		}
		return convertedSectorList;
	}

	public static List<Branch> convertDBBranchListToServiceBranchList(
			List<in.jobcounsel.services.db.entities.Branch> branches) {
		List<Branch> convertedBranchList = new ArrayList<Branch>();
		if (null != branches && branches.size() > 0) {
			convertedBranchList = branches.parallelStream().map(dbBranch -> new Branch(Long.valueOf(dbBranch.getId()),
					dbBranch.getName(), dbBranch.getStamp_created())).collect(Collectors.toList());

			return convertedBranchList;
		}
		return convertedBranchList;
	}

	public static List<Organization> convertDBOrgListToServiceOrgList(
			List<in.jobcounsel.services.db.entities.Organization> organizations) {
		List<Organization> convertedOrgList = new ArrayList<Organization>();
		if (null != organizations && organizations.size() > 0) {
			convertedOrgList = organizations.parallelStream().map(dbOrg -> new Organization(Long.valueOf(dbOrg.getId()),
					dbOrg.getName(), dbOrg.getStamp_created(), dbOrg.getSectorId())).collect(Collectors.toList());

			return convertedOrgList;
		}
		return convertedOrgList;
	}

	private static in.jobcounsel.services.db.entities.Sector convertResponseSectorToDBSector(Sector sector) {
		in.jobcounsel.services.db.entities.Sector dbSector = new in.jobcounsel.services.db.entities.Sector();

		if (sector != null) {
			dbSector.setId(sector.getId().intValue());
			dbSector.setName(sector.getName());
			dbSector.setTimeStamp(new Timestamp(sector.getCreationDate().getDate()));
		}

		return dbSector;
	}

	private static in.jobcounsel.services.db.entities.Branch convertResponseBranchToDBBranch(Branch branch) {
		in.jobcounsel.services.db.entities.Branch dbBranch = new in.jobcounsel.services.db.entities.Branch();
		if (branch != null) {
			dbBranch.setId(branch.getId().intValue());
			dbBranch.setName(branch.getName());
			dbBranch.setStamp_created(new Timestamp(branch.getCreationDate().getTime()));
		}
		return dbBranch;
	}

	private static in.jobcounsel.services.db.entities.Organization convertResponseOrgToDBOrg(Organization org) {

		in.jobcounsel.services.db.entities.Organization dbOrg = new in.jobcounsel.services.db.entities.Organization();

		dbOrg.setId(org.getId().intValue());
		dbOrg.setSectorId(convertResponseSectorToDBSector(org.getSector()));
		dbOrg.setName(org.getName());
		dbOrg.setStamp_created(new Timestamp(org.getCreationDate().getTime()));

		return dbOrg;

	}

	public static in.jobcounsel.services.db.entities.Job convertJobReqToJob(JobReq jobReq, List<Branch> branchList,
			List<Organization> orgList) {

		in.jobcounsel.services.db.entities.Job job = new in.jobcounsel.services.db.entities.Job();

		if (jobReq != null) {
			Branch branchMapped = null;
			Organization orgMapped = null;

			Optional<Branch> mappedBranch = branchList.parallelStream()
					.filter(branch -> branch.getName().equalsIgnoreCase(jobReq.getBranch())).findFirst();
			if (mappedBranch.isPresent()) {
				branchMapped = mappedBranch.get();
				in.jobcounsel.services.db.entities.Branch entityBranch = new in.jobcounsel.services.db.entities.Branch();
				// entityBranch.setId(Integer.valueOf(branchIdMapped));

			}
			Optional<Organization> organizationMapped = orgList.parallelStream()
					.filter(org -> org.getName().equalsIgnoreCase(jobReq.getOrganization())).findFirst();
			if (organizationMapped.isPresent()) {
				orgMapped = organizationMapped.get();
			}

			job.setDescription(jobReq.getWorkDescription());
			job.setEligibilitycriteria(jobReq.getEligibilityCriteria());
			job.setJobApplyLastDate(AppUtility.convertStringDateToSQLDate(jobReq.getJobApplyLastDate()));
			job.setJobapplylnk(jobReq.getJobApplyLnk());
			job.setJobdetailslnk(jobReq.getJobDetailsLnk());
			job.setJobtype(jobReq.getJobType());
			job.setOrgid(convertResponseOrgToDBOrg(organizationMapped.get()));
			job.setBranchid(convertResponseBranchToDBBranch(mappedBranch.get()));
			job.setQualification(jobReq.getWorkQualfication());
			job.setSelectionprocess(jobReq.getSelectionProcess());
			job.setTags(jobReq.getTags());

		}

		return job;
	}

}
