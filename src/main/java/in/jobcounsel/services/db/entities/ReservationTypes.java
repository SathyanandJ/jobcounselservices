package in.jobcounsel.services.db.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ReservationTypes")
public class ReservationTypes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "reservationtype")
	private String reservationtype;
	
	@Column(name = "stamp_created")
	private Timestamp stamp_created;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReservationtype() {
		return reservationtype;
	}

	public void setReservationtype(String reservationtype) {
		this.reservationtype = reservationtype;
	}

	public Timestamp getStamp_created() {
		return stamp_created;
	}

	public void setStamp_created(Timestamp stamp_created) {
		this.stamp_created = stamp_created;
	}

}
