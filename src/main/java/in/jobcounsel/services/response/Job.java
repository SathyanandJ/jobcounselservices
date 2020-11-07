package in.jobcounsel.services.response;

import java.util.Date;

public class Job {

	private long id;
	private String organizationName;
	private String branchName;
	private int salaryPerMonth;
	private String designation;
	private String qualification;
	private String location;
	private Date jobApplyLastDate;
	private String details="details";

	public Job() {

	}

	public Job(Long id, String orgName, String branchName, int salaryPerMonth, String designation, String qualification,
			String jobLocation, Date jobApplyLastDate) {
		this.id = id;
		this.organizationName = orgName;
		this.branchName = branchName;
		this.salaryPerMonth = salaryPerMonth;
		this.designation = designation;
		this.qualification = qualification;
		this.location = jobLocation;
		this.jobApplyLastDate = jobApplyLastDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getSalaryPerMonth() {
		return salaryPerMonth;
	}

	public void setSalaryPerMonth(int salaryPerMonth) {
		this.salaryPerMonth = salaryPerMonth;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getJobApplyLastDate() {
		return jobApplyLastDate;
	}

	public void setJobApplyLastDate(Date jobApplyLastDate) {
		this.jobApplyLastDate = jobApplyLastDate;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
