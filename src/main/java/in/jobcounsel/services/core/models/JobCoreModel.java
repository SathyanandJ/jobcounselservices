package in.jobcounsel.services.core.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class JobCoreModel {

	@Getter @Setter private long id;
	@Getter @Setter private String organizationName;
	@Getter @Setter private String branchName;
	@Getter @Setter private int minSalary;
	@Getter @Setter private int maxSalary;
	@Getter @Setter private String designation;
	@Getter @Setter private String qualification;
	@Getter @Setter private String description;
	@Getter @Setter private String eligibilitycriteria;
	@Getter @Setter private String location;
	@Getter @Setter private String jobdetailsLnk;
	@Getter @Setter private String jobApplyLnk;
	@Getter @Setter private Date jobApplyLastDate;
	@Getter @Setter private String selectionProcess;
	@Getter @Setter private int totalVacancies;
	@Getter @Setter private String jobType;
	@Getter @Setter private String tags;
	@Getter @Setter private Date dateAdded;
	

}
