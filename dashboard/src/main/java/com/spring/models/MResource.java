package com.spring.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="MResource")
public class MResource{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="associateid")
	private Long associateid;
	@Column(name="associatename")
	private String associatename;	
	@Column(name="reportingmanager")
	private String reportingmanager;
	@Column(name="msatpid")
	private String msatpid;
	@Column(name="location")
	private String location;
	@Column(name="status")
	private String status;
	@Column(name="inactivereason")
	private String inactivereason;
	@Column(name="remarks")
	private String remarks;
	@Column(name="emailid")
	private String emailid;
	@Column(name="scotiaemailid")
	private String scotiaemailid;
	@Column(name="band")
	private String band;
	@Column(name="billingrate")
	private Long billingrate;
	@Column(name = "user", nullable = false)
	private String user;
	@Access(AccessType.PROPERTY)
	@ManyToMany(targetEntity=SOWMaster.class, fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@ElementCollection(targetClass=SOWMaster.class)
	private List<SOWMaster> sow = new ArrayList<SOWMaster>();
	
	public MResource() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getAssociateid() {
		return associateid;
	}

	public void setAssociateid(Long associateid) {
		this.associateid = associateid;
	}

	public String getAssociatename() {
		return associatename;
	}

	public void setAssociatename(String associatename) {
		this.associatename = associatename;
	}

	public String getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(String reportingmanager) {
		this.reportingmanager = reportingmanager;
	}

	public String getMsatpid() {
		return msatpid;
	}

	public void setMsatpid(String msatpid) {
		this.msatpid = msatpid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInactivereason() {
		return inactivereason;
	}

	public void setInactivereason(String inactivereason) {
		this.inactivereason = inactivereason;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getScotiaemailid() {
		return scotiaemailid;
	}

	public void setScotiaemailid(String scotiaemailid) {
		this.scotiaemailid = scotiaemailid;
	}

	public String getBand() {
		return band;
	}

	public void setBand(String band) {
		this.band = band;
	}
	
	public Long getBillingrate() {
		return billingrate;
	}

	public void setBillingrate(Long billingrate) {
		this.billingrate = billingrate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
		
	public List<SOWMaster> getSow() {
		return sow;
	}

	public void setSow(List<SOWMaster> sow) {
		this.sow = sow;
	}

	public static void setResourceNameComparator(Comparator<MResource> resourceNameComparator) {
		ResourceNameComparator = resourceNameComparator;
	}

	public static Comparator<MResource> getResourceNameComparator() {
		return ResourceNameComparator;
	}

	public static void setContactNameComparator(Comparator<MResource> resourceNameComparator) {
		ResourceNameComparator = resourceNameComparator;
	}
	
	@Override
	public String toString() {
		return "MResource [id=" + id + ", associateName=" + associatename + ", reportingManager=" + reportingmanager
				+ ", MSAT_PID=" + msatpid + ", location=" + location + ", status=" + status + ", inactiveReason="
				+ inactivereason + ", remarks=" + remarks + ", emailId=" + emailid + ", scotiaEmailId=" + scotiaemailid
				+ ", band=" + band + ", user=" + user + "]";
	}

	public static Comparator<MResource> ResourceNameComparator = new Comparator<MResource>() {

		public int compare(MResource r1, MResource r2) {
			return r1.getId().compareTo(r2.getId());
		}
	};
	
}
