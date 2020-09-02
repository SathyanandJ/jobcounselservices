package in.jobcounsel.services.response;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Job {

	private long id;
	private String organizationName;
	private String branchName;
	private String qualification;
	private String description;
	private String jobdetailslnk;
	private String jobapplylnk;
	private Date jobApplyLastDate;
	private Timestamp stamp_created;
	private Timestamp stamp_updated;

	public Job() {

	}
	
	public Job(Long id,String orgName,String branchName,String qualification,String description,String jobDetailsLnk,String jobApplyLink, Date jobApplyLastDate,Timestamp jobUpdatedTime) {
		this.id = id;
		this.organizationName = orgName;
		this.branchName = branchName;
		this.qualification = qualification;
		this.description = description;
		this.jobdetailslnk = jobDetailsLnk;
		this.jobapplylnk = jobApplyLink;
		this.jobApplyLastDate= jobApplyLastDate;
		this.stamp_updated = jobUpdatedTime;
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

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJobdetailslnk() {
		return jobdetailslnk;
	}

	public void setJobdetailslnk(String jobdetailslnk) {
		this.jobdetailslnk = jobdetailslnk;
	}

	public String getJobapplylnk() {
		return jobapplylnk;
	}

	public void setJobapplylnk(String jobapplylnk) {
		this.jobapplylnk = jobapplylnk;
	}

	public Date getJobApplyLastDate() {
		return jobApplyLastDate;
	}

	public void setJobApplyLastDate(Date jobApplyLastDate) {
		this.jobApplyLastDate = jobApplyLastDate;
	}

	public Timestamp getStamp_created() {
		return stamp_created;
	}

	public void setStamp_created(Timestamp stamp_created) {
		this.stamp_created = stamp_created;
	}

	public Timestamp getStamp_updated() {
		return stamp_updated;
	}

	public void setStamp_updated(Timestamp stamp_updated) {
		this.stamp_updated = stamp_updated;
	}

}
