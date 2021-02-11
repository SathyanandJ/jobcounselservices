package in.jobcounsel.services.response;

public class OrganizationsHiring {

	private Integer organizationId;
	private String organizationName;
	private Integer totalVacancies;
	private Long sectorId;

	public OrganizationsHiring(Integer orgId, String orgName, Integer totalVacancies, Long sectorId) {
		this.organizationId = orgId;
		this.organizationName = orgName;
		this.totalVacancies = totalVacancies;
		this.sectorId = sectorId;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Integer getTotalVacancies() {
		return totalVacancies;
	}

	public void setTotalVacancies(Integer totalVacancies) {
		this.totalVacancies = totalVacancies;
	}

	public Long getSectorId() {
		return sectorId;
	}

	public void setSectorId(Long sectorId) {
		this.sectorId = sectorId;
	}

}
