package in.jobcounsel.services.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobDetail;

@Service
public class JobsCoreBusinessHelperImpl implements JobsCoreBusinessHelper {

	@Override
	public List<Job> extractJobDataFromDB(List<JobCoreModel> jobDBData) {
		List<Job> transformedJobData = new ArrayList<>();
		transformedJobData = jobDBData.parallelStream()
				.map(jobData -> new Job(jobData.getId(), jobData.getOrganizationName(), jobData.getBranchName(),
						(jobData.getMaxSalary() == 0) ? jobData.getMinSalary() : jobData.getMaxSalary(),
						jobData.getDesignation(), jobData.getQualification(), jobData.getLocation(),
						jobData.getJobApplyLastDate()))
				.collect(Collectors.toList());

		return transformedJobData;
	}

	@Override
	public List<JobDetail> extractFullJobDataFromDB(List<JobCoreModel> jobDBData) {
		List<JobDetail> transformedJobData = new ArrayList<>();
		transformedJobData = jobDBData.parallelStream()
				.map(jobData -> new JobDetail(jobData.getId(), jobData.getOrganizationName(), jobData.getBranchName(),
						(jobData.getMaxSalary() == 0) ? jobData.getMinSalary() : jobData.getMaxSalary(),
						jobData.getDesignation(), jobData.getQualification(), jobData.getDescription(),
						jobData.getEligibilitycriteria(), jobData.getLocation(), jobData.getJobdetailsLnk(),
						jobData.getJobApplyLnk(), jobData.getJobApplyLastDate(), jobData.getSelectionProcess(),
						jobData.getTotalVacancies(), jobData.getJobType(), jobData.getDateAdded()))
				.collect(Collectors.toList());

		return transformedJobData;
	}
}
