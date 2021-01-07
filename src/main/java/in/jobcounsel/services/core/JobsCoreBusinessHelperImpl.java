package in.jobcounsel.services.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.utility.AppUtility;

@Service
public class JobsCoreBusinessHelperImpl implements JobsCoreBusinessHelper {

	@Override
	public List<Job> extractJobDataFromDB(List<JobCoreModel> jobDBData) {
		List<Job> transformedJobData = new ArrayList<>();
		transformedJobData = jobDBData.parallelStream()
				.map(jobData -> new Job(jobData.getId(), jobData.getOrganizationName(), jobData.getBranchName(),
						(jobData.getMaxSalary() == 0) ? jobData.getMinSalary() : jobData.getMaxSalary(),
						jobData.getDesignation(), jobData.getQualification(), jobData.getLocation(),
						AppUtility.convertToIndianDateFormat(jobData.getJobApplyLastDate())))
				.collect(Collectors.toList());

		return transformedJobData;
	}

	@Override
	public List<JobDetail> extractFullJobDataFromDB(List<JobCoreModel> jobDBData) {
		List<JobDetail> transformedJobData = new ArrayList<>();
		transformedJobData = jobDBData.parallelStream()
				.map(jobData -> new JobDetail(jobData.getId(), jobData.getOrganizationName(),
						jobData.getOrganizationURL(), jobData.getBranchName(), jobData.getStateName(),
						(jobData.getMaxSalary() == 0) ? jobData.getMinSalary() : jobData.getMaxSalary(),
						jobData.getJobTitle(), jobData.getDesignation(),
						convertStringTextToBrokenString(jobData.getQualification()),
						convertStringTextToBrokenString(jobData.getDescription()),
						convertStringTextToBrokenString(jobData.getEligibilitycriteria()), jobData.getLocation(),
						jobData.getJobdetailsLnk(), jobData.getJobApplyLnk(),
						AppUtility.convertToIndianDateFormat(jobData.getJobApplyLastDate()),
						convertStringTextToBrokenString(jobData.getSelectionProcess()), jobData.getTotalVacancies(),
						jobData.getJobType(), jobData.getDateAdded()))
				.collect(Collectors.toList());

		return transformedJobData;
	}

	private List<String> convertStringTextToBrokenString(String text) {
		String splitText[] = text.trim().split("\\.");
		List<String> responseText = filterTextByLength(Arrays.asList(splitText));
		return responseText;
	}
	
	private List<String> filterTextByLength(List<String> splitText) {
		List<String> newText = new ArrayList<>();
		for(String str:splitText) {
			if(str.length()>5) {
				newText.add(str.trim());
			}
		}
		return newText;
	}
}
