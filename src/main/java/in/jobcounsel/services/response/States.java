package in.jobcounsel.services.response;

public class States {

	private Integer id;
	private String stateName;
	private String stateAbbr;

	public States() {

	}

	public States(Integer id, String stateName, String stateAbbr) {
		this.id = id;
		this.stateAbbr = stateAbbr;
		this.stateName = stateName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateAbbr() {
		return stateAbbr;
	}

	public void setStateAbbr(String stateAbbr) {
		this.stateAbbr = stateAbbr;
	}

}
