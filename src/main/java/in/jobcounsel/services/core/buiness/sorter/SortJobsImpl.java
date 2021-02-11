package in.jobcounsel.services.core.buiness.sorter;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import in.jobcounsel.services.core.models.JobCoreModel;

@Service
public class SortJobsImpl implements SortJobs {

	@Override
	public List<JobCoreModel> sortJobsNextExpiryFirst(List<JobCoreModel> unsortedJobs) {
		Map<JobCoreModel, Integer> jobTempHolder = new HashMap<>();
		for (JobCoreModel job : unsortedJobs) {
			jobTempHolder.put(job, calculateJobExpiryDate(job.getJobApplyLastDate()));
		}
		List<JobCoreModel> sortedJobs = jobTempHolder.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).collect(Collectors.toList());
		
		return sortedJobs;
	}

	private Integer calculateJobExpiryDate(Date jobApplyLastDate) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		LocalDate applyDate = LocalDate.parse(formatter.format(jobApplyLastDate), dtf);
		LocalDate currentDate = LocalDate.now();

		long result = Duration.between(currentDate.atStartOfDay(), applyDate.atStartOfDay()).toDays();

		if (result < 0) {
			if (result > -7 && result < -1) // Jobs Recently expired
				return 6;
			else if (result <= -7) // Expired and Old Jobs gets Moved to Last
				return 10;
		} else {
			if (result < 7) // Job Expiry Within a Week
				return 1;
			else if (result < 21) // Job Expiry Within 3 Weeks
				return 2;
			else if (result >= 21) // Job Expiry Above 3 Weeks
				return 4;
		}

		return 5;
	}

}
