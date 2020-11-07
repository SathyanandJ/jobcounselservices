package in.jobcounsel.services.request;

public class JobReq {

	private String sector;
	private String branch;
	private String organization;
	private String workQualfication;
	private String workDescription;
	private String eligibilityCriteria;
	private String jobDetailsLnk;
	private String jobApplyLnk;
	private String jobApplyLastDate;
	private String selectionProcess;
	private String jobType;
	private String tags;

	public JobReq() {

	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getWorkQualfication() {
		return workQualfication;
	}

	public void setWorkQualfication(String workQualfication) {
		this.workQualfication = workQualfication;
	}

	public String getWorkDescription() {
		return workDescription;
	}

	public void setWorkDescription(String workDescription) {
		this.workDescription = workDescription;
	}

	public String getEligibilityCriteria() {
		return eligibilityCriteria;
	}

	public void setEligibilityCriteria(String eligibilityCriteria) {
		this.eligibilityCriteria = eligibilityCriteria;
	}

	public String getJobDetailsLnk() {
		return jobDetailsLnk;
	}

	public void setJobDetailsLnk(String jobDetailsLnk) {
		this.jobDetailsLnk = jobDetailsLnk;
	}

	public String getJobApplyLnk() {
		return jobApplyLnk;
	}

	public void setJobApplyLnk(String jobApplyLnk) {
		this.jobApplyLnk = jobApplyLnk;
	}

	public String getJobApplyLastDate() {
		return jobApplyLastDate;
	}

	public void setJobApplyLastDate(String jobApplyLastDate) {
		this.jobApplyLastDate = jobApplyLastDate;
	}

	public String getSelectionProcess() {
		return selectionProcess;
	}

	public void setSelectionProcess(String selectionProcess) {
		this.selectionProcess = selectionProcess;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
