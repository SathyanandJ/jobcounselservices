package in.jobcounsel.services.response;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Branch {
	
	private Long id;
	private String name;
	@JsonIgnore
	private Date creationDate;
	
	public Branch(Long id,String name, Timestamp timeStamp){
		this.id=id;
		this.name = name;
		this.creationDate = timeStamp;
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
	
}
