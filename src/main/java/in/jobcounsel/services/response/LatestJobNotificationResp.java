package in.jobcounsel.services.response;

public class LatestJobNotificationResp {

	private Integer jobId;
	private String orgWithVacancies;

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getOrgWithVacancies() {
		return orgWithVacancies;
	}

	public void setOrgWithVacancies(String orgWithVacancies) {
		this.orgWithVacancies = orgWithVacancies;
	}

}
