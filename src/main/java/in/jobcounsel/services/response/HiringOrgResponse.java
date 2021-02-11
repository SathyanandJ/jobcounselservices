package in.jobcounsel.services.response;

import java.util.List;
import java.util.Map;

public class HiringOrgResponse {

	private Map<Integer, List<OrganizationsHiring>> orgHiring;

	public Map<Integer, List<OrganizationsHiring>> getOrgHiring() {
		return orgHiring;
	}

	public void setOrgHiring(Map<Integer, List<OrganizationsHiring>> orgHiring) {
		this.orgHiring = orgHiring;
	}

}
