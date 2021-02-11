package in.jobcounsel.services.db.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Subscription")
public class EmailSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	private String email;

	@Column(name = "emailguid")
	private String emailguid;

	@Column(name = "isemailverified")
	private char isEmailVerified;

	@Column(name = "subscriptionstatus")
	private char isSubscribed;

	@Column(name = "stamp_updated" , nullable = false, updatable = true, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp stamp_updated;

	@Column(name = "stamp_created", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp stamp_created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailguid() {
		return emailguid;
	}

	public void setEmailguid(String emailguid) {
		this.emailguid = emailguid;
	}

	public char getIsEmailVerified() {
		return isEmailVerified;
	}

	public void setIsEmailVerified(char isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	public char getIsSubscribed() {
		return isSubscribed;
	}

	public void setIsSubscribed(char isSubscribed) {
		this.isSubscribed = isSubscribed;
	}

	public Timestamp getStamp_updated() {
		return stamp_updated;
	}

	public void setStamp_updated(Timestamp stamp_updated) {
		this.stamp_updated = stamp_updated;
	}

	public Timestamp getStamp_created() {
		return stamp_created;
	}

	public void setStamp_created(Timestamp stamp_created) {
		this.stamp_created = stamp_created;
	}

}
