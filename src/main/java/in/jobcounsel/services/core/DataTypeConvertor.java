package in.jobcounsel.services.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import in.jobcounsel.services.response.Branch;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.Organization;
import in.jobcounsel.services.response.Sector;

public class DataTypeConvertor {

	public static List<Job> convertDBListToServiceList(List<in.jobcounsel.services.db.entities.Job> jobs) {
		List<Job> convertedJobList = new ArrayList<Job>();
		if (null != jobs && jobs.size() >0) {
			convertedJobList = jobs.parallelStream()
					.map(dbJob -> new Job(Long.valueOf(dbJob.getId()), dbJob.getOrgid().getName(),
							dbJob.getBranchid().getName(), dbJob.getQualification(), dbJob.getDescription(),
							dbJob.getJobdetailslnk(), dbJob.getJobapplylnk(), dbJob.getJobApplyLastDate(),
							dbJob.getStamp_updated()))
					.collect(Collectors.toList());

			return convertedJobList;
		}
		return convertedJobList;
	}
	
	public static List<Sector> convertDBSectorListToServiceSectorList(List<in.jobcounsel.services.db.entities.Sector> sector) {
		 List<Sector> convertedSectorList = new  ArrayList<Sector> ();
		if (null != sector && sector.size() >0) {
			convertedSectorList = sector.parallelStream()
					.map(dbSector -> new Sector(Long.valueOf(dbSector.getId()),dbSector.getName(),dbSector.getTimeStamp()))
					.collect(Collectors.toList());

			return convertedSectorList;
		}
		return convertedSectorList;
	}
	
	public static List<Branch> convertDBBranchListToServiceBranchList(List<in.jobcounsel.services.db.entities.Branch> branches) {
		 List<Branch> convertedBranchList = new  ArrayList<Branch> ();
		if (null != branches && branches.size() >0) {
			convertedBranchList = branches.parallelStream()
					.map(dbBranch -> new Branch(Long.valueOf(dbBranch.getId()),dbBranch.getName(),dbBranch.getStamp_created()))
					.collect(Collectors.toList());

			return convertedBranchList;
		}
		return convertedBranchList;
	}
	
	public static List<Organization> convertDBOrgListToServiceOrgList(List<in.jobcounsel.services.db.entities.Organization> organizations) {
		 List<Organization> convertedOrgList = new  ArrayList<Organization> ();
		if (null != organizations && organizations.size() >0) {
			convertedOrgList = organizations.parallelStream()
					.map(dbOrg -> new Organization(Long.valueOf(dbOrg.getId()),dbOrg.getName(),dbOrg.getStamp_created(),dbOrg.getSectorId()))
					.collect(Collectors.toList());

			return convertedOrgList;
		}
		return convertedOrgList;
	}

}
