package in.jobcounsel.services.startup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import in.jobcounsel.platform.exception.JobServicesException;
import in.jobcounsel.services.JobCounselServices;
import in.jobcounsel.services.core.search.DataSearchOperations;
import in.jobcounsel.services.response.Job;

@Configuration
public class ApplicationStartupOperations implements InitializingBean {

	@Autowired
	JobCounselServices jobServices;

	@Autowired
	DataSearchOperations dataSearchOperations;

	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartupOperations.class);

	@Override
	public void afterPropertiesSet() throws Exception {
		resetJobIndexing();
		indexDBJobText();
	}

	private boolean resetJobIndexing() {
		try {
			dataSearchOperations.resetDataInIndex();
		} catch (Exception e) {
			logger.error("Error Occured While deleting the index Failed");
			logger.error("Reset Index Operation failed Error Message : {}", e.getLocalizedMessage());
		}
		return true;
	}

	private boolean indexDBJobText() throws JobServicesException {
		List<Map<String, String>> jobsToIndex = new ArrayList<>();
		try {
			for (int i = 1; i <= 5; i++) {

				List<Job> jobs = jobServices.getAllJobsBySector(i);

				jobsToIndex.addAll(processJob(jobs));

			}
			dataSearchOperations.addDataToIndex(jobsToIndex);
			logger.debug("Total Amount Of Jobs Added To Index : {}", jobsToIndex.size());
		} catch (Throwable t) {
			logger.error("Critical Error Happened While Starting up the Application");
			logger.error("Must Perform Operations On Start up failed");
			logger.error("Startup Operation Error Message : {}", t.getLocalizedMessage());
		}

		return true;
	}

	private List<Map<String, String>> processJob(List<Job> jobs) {
		List<Map<String, String>> convertedJobs = new ArrayList<>();
		for (Job job : jobs) {
			try {
				convertedJobs.add(convertJobForSending(job));
			} catch (Exception e) {
				logger.error("Critical Error Occured While Converting the Job To Map For Indexing Message : {}",
						e.getLocalizedMessage());
			}
		}
		return convertedJobs;
	}

	private Map<String, String> convertJobForSending(Job job) {
		Map<String, String> dataMap = new HashMap<>();

		dataMap.put("ID", String.valueOf(job.getId()));
		dataMap.put("JOBLOCATION", job.getLocation());
		dataMap.put("JOBQUALIFICATION", job.getQualification());
		dataMap.put("JOBDESIGNATION", job.getDesignation());
		dataMap.put("JOBORGANIZATION", job.getOrganizationName());

		return dataMap;

	}

}
