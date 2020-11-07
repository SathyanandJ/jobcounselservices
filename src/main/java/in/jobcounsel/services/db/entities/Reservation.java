package in.jobcounsel.services.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "reservationtypeid")
	private int reservationtypeid;

	@Column(name = "jobid")
	private int jobid;

	@Column(name = "applicationfee")
	private int applicationfee;

	@Column(name = "jobvacancies")
	private int jobvacancies;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReservationtypeid() {
		return reservationtypeid;
	}

	public void setReservationtypeid(int reservationtypeid) {
		this.reservationtypeid = reservationtypeid;
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public int getApplicationfee() {
		return applicationfee;
	}

	public void setApplicationfee(int applicationfee) {
		this.applicationfee = applicationfee;
	}

	public int getJobvacancies() {
		return jobvacancies;
	}

	public void setJobvacancies(int jobvacancies) {
		this.jobvacancies = jobvacancies;
	}
	
}
