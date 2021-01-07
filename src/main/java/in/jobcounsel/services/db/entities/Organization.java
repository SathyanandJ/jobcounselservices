package in.jobcounsel.services.db.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

@Entity
@Table(name = "Organization")
@SecondaryTables({ @SecondaryTable(name = "Sector"), @SecondaryTable(name = "states") })
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sectorid", nullable = false, insertable = false, updatable = false)
	private Sector sectorId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "stateid", nullable = false, insertable = true, updatable = true)
	private States stateId;

	@Column(name = "name")
	private String name;

	@Column(name = "orgurl")
	private String orgURL;

	@Column(name = "aboutorg")
	private String aboutOrg;

	@Column(name = "orgcareerurl")
	private String orgCareerURL;

	@Column(name = "stamp_created")
	private Timestamp stamp_created;

	@Column(name = "stamp_updated")
	private Timestamp stamp_updated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sector getSectorId() {
		return sectorId;
	}

	public void setSectorId(Sector sectorId) {
		this.sectorId = sectorId;
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

	public States getStateId() {
		return stateId;
	}

	public void setStateId(States stateId) {
		this.stateId = stateId;
	}

	public String getAboutOrg() {
		return aboutOrg;
	}

	public void setAboutOrg(String aboutOrg) {
		this.aboutOrg = aboutOrg;
	}

	public String getOrgCareerURL() {
		return orgCareerURL;
	}

	public void setOrgCareerURL(String orgCareerURL) {
		this.orgCareerURL = orgCareerURL;
	}

	public Timestamp getStamp_created() {
		return stamp_created;
	}

	public void setStamp_created(Timestamp stamp_created) {
		this.stamp_created = stamp_created;
	}

	public Timestamp getStamp_updated() {
		return stamp_updated;
	}

	public void setStamp_updated(Timestamp stamp_updated) {
		this.stamp_updated = stamp_updated;
	}
}
