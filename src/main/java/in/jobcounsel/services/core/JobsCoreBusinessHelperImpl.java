package in.jobcounsel.services.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;

import in.jobcounsel.services.core.models.JobCoreModel;
import in.jobcounsel.services.response.Job;
import in.jobcounsel.services.response.JobDetail;
import in.jobcounsel.services.utility.AppUtility;

@Service
public class JobsCoreBusinessHelperImpl implements JobsCoreBusinessHelper {

	Logger logger = LoggerFactory.getLogger(JobsCoreBusinessHelperImpl.class);

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
		for (String str : splitText) {
			if (str.length() > 5) {
				newText.add(str.trim());
			}
		}
		return newText;
	}

	@Override
	public Boolean createPDFWithJobData(List<JobCoreModel> jobList, String fileName) {
		Boolean result = true;
		try {

			JobPDFFileCreation.createJobPDFFile(fileName, jobList);

		} catch (Exception e) {
			logger.error("Error Occured While creation the Job PDF File Error msg : {}", e.getLocalizedMessage());
			result = false;
		}
		return result;
	}

}
