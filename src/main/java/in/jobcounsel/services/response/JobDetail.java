package in.jobcounsel.services.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class JobDetail {

	@Getter
	@Setter
	private long id;
	@Getter
	@Setter
	private String organizationName;
	@Getter
	@Setter
	private String branchName;
	@Getter
	@Setter
	private int salaryPerMonth;
	@Getter
	@Setter
	private String designation;
	@Getter
	@Setter
	private String qualification;
	@Getter
	@Setter
	private String description;
	@Getter
	@Setter
	private String eligibilityCriteria;
	@Getter
	@Setter
	private String jobLocation;
	@Getter
	@Setter
	private String jobdetailslnk;
	@Getter
	@Setter
	private String jobapplylnk;
	@Getter
	@Setter
	private Date jobApplyLastDate;
	@Getter
	@Setter
	private String selectionProcess;
	@Getter
	@Setter
	private int totalVacancies;
	@Getter
	@Setter
	private String jobType;
	@Getter
	@Setter
	private Date dateAdded;

}
