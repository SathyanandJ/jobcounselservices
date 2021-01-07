package in.jobcounsel.services.response;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Organization {

	private Long id;
	private String name;
	private String orgURL;
	private String orgAboutUSURL;
	@JsonIgnore
	private Date creationDate;
	private Sector sector;
	private States state;

	public Organization(Long id, String name, Timestamp timeStamp, in.jobcounsel.services.db.entities.Sector sector,
			String orgURL, String orgAboutUSURL, in.jobcounsel.services.db.entities.States state) {
		this.id = id;
		this.name = name;
		this.creationDate = timeStamp;
		this.orgURL = orgURL;
		this.orgAboutUSURL = orgAboutUSURL;
		this.sector = new Sector(Long.valueOf(sector.getId()), sector.getName(), sector.getTimeStamp());
		this.state = new States(state.getId(), state.getStatename(), state.getStateabbr());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrgURL() {
		return orgURL;
	}

	public void setOrgURL(String orgURL) {
		this.orgURL = orgURL;
	}

	public String getOrgAboutUSURL() {
		return orgAboutUSURL;
	}

	public void setOrgAboutUSURL(String orgAboutUSURL) {
		this.orgAboutUSURL = orgAboutUSURL;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

}
