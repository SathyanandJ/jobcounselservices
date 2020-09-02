package in.jobcounsel.services.response;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Organization {
	
	private Long id;
	private String name;
	@JsonIgnore
	private Date creationDate;
	private Sector sector;
	
	public Organization(Long id,String name, Timestamp timeStamp,in.jobcounsel.services.db.entities.Sector sector){
		this.id=id;
		this.name = name;
		this.creationDate = timeStamp;
		this.sector = new Sector(Long.valueOf(sector.getId()),sector.getName(),sector.getTimeStamp());
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
}
