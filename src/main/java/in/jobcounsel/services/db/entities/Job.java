package in.jobcounsel.services.db.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "Job")
//@SecondaryTable(name="Organization")
@SecondaryTables({ @SecondaryTable(name = "Organization"), @SecondaryTable(name = "Branch") ,@SecondaryTable(name ="Salary")})
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orgid", nullable = false, insertable = true, updatable = true)
	private Organization orgid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "branchid", nullable = false, insertable = true, updatable = true)
	private Branch branchid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "salaryid", nullable = false, insertable = true, updatable = true)
	private Salary salaryID;
	
	@Column(name = "designation")
	private String designation;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "description")
	private String description;

	@Column(name = "eligibilitycriteria")
	private String eligibilitycriteria;
	
	@Column(name = "joblocation")
	private String jobLocation;

	@Column(name = "jobdetailslnk")
	private String jobdetailslnk;

	@Column(name = "jobapplylnk")
	private String jobapplylnk;

	@Column(name = "jobapplylastdate")
	private Date jobApplyLastDate;

	@Column(name = "selectionprocess")
	private String selectionprocess;
	
	@Column(name = "totalvancancies")
	private int totalVacancies;

	@Column(name = "jobtype")
	private String jobtype;

	@Column(name = "tags")
	private String tags;

	@Column(name = "stamp_created")
	private Timestamp stamp_created;

	@Column(name = "stamp_updated")
	private Timestamp stamp_updated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Organization getOrgid() {
		return orgid;
	}

	public void setOrgid(Organization orgid) {
		this.orgid = orgid;
	}

	public Branch getBranchid() {
		return branchid;
	}

	public void setBranchid(Branch branchid) {
		this.branchid = branchid;
	}

	public Salary getSalaryID() {
		return salaryID;
	}

	public void setSalaryID(Salary salaryID) {
		this.salaryID = salaryID;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEligibilitycriteria() {
		return eligibilitycriteria;
	}

	public void setEligibilitycriteria(String eligibilitycriteria) {
		this.eligibilitycriteria = eligibilitycriteria;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
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

	public String getSelectionprocess() {
		return selectionprocess;
	}

	public void setSelectionprocess(String selectionprocess) {
		this.selectionprocess = selectionprocess;
	}

	public int getTotalVacancies() {
		return totalVacancies;
	}

	public void setTotalVacancies(int totalVacancies) {
		this.totalVacancies = totalVacancies;
	}

	public String getJobtype() {
		return jobtype;
	}

	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
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
