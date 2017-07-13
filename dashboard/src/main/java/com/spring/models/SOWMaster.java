package com.spring.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "SOWMaster")
public class SOWMaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="client")
	private String client;
	@Column(name="msatsopocemailid")
	private String msatsopocemailid;
	@Column(name="contracttype")
	private String contracttype;
	@Column(name="recordtype")
	private String recordtype;
	@Column(name="opnumber")
	private String opnumber;
	@Column(name="wanumber")
	private String wanumber;
	@Column(name="watype")
	private String watype;
	@Column(name="wastatus")
	private String wastatus;
	@Column(name="wastatusdate")
	private Date wastatusdate;
	@Column(name="startdate")
	private Date startdate;
	@Column(name="expirydate")
	private Date expirydate;
	@Column(name="waamount")
	private Long waamount;
	@Column(name="wabalance")
	private Long wabalance;
	@Column(name="projectname")
	private String projectname;
	@Column(name="msatpid")
	private String msatpid;
	@Column(name="contractno")
	private String contractno;
	@Column(name="location")
	private String location;
	@Column(name="tag")
	private String tag;
	@Column(name="upside")
	private String upside;
	@Column(name = "user", nullable = false)
	private String user;
	
	@Access(AccessType.PROPERTY)
	@ManyToMany(targetEntity=MResource.class,  fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinTable(name = "SOWMaster_MResource", catalog = "test", joinColumns = {
			@JoinColumn(name = "sowid", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "id",
					nullable = false, updatable = false) })
	private List<MResource> associates = new ArrayList<MResource>();
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	public SOWMaster() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getMsatsopocemailid() {
		return msatsopocemailid;
	}

	public void setMsatsopocemailid(String msatsopocemailid) {
		this.msatsopocemailid = msatsopocemailid;
	}

	public String getContracttype() {
		return contracttype;
	}

	public void setContracttype(String contracttype) {
		this.contracttype = contracttype;
	}

	public String getRecordtype() {
		return recordtype;
	}

	public void setRecordtype(String recordtype) {
		this.recordtype = recordtype;
	}

	public String getOpnumber() {
		return opnumber;
	}

	public void setOpnumber(String opnumber) {
		this.opnumber = opnumber;
	}

	public String getWanumber() {
		return wanumber;
	}

	public void setWanumber(String wanumber) {
		this.wanumber = wanumber;
	}

	public String getWatype() {
		return watype;
	}

	public void setWatype(String watype) {
		this.watype = watype;
	}

	public String getWastatus() {
		return wastatus;
	}

	public void setWastatus(String wastatus) {
		this.wastatus = wastatus;
	}

	public Date getWastatusdate() {
		return wastatusdate;
	}

	public void setWastatusdate(Date wastatusdate) {
		this.wastatusdate = wastatusdate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public Long getWaamount() {
		return waamount;
	}

	public void setWaamount(Long waamount) {
		this.waamount = waamount;
	}

	public Long getWabalance() {
		return wabalance;
	}

	public void setWabalance(Long wabalance) {
		this.wabalance = wabalance;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public String getMsatpid() {
		return msatpid;
	}

	public void setMsatpid(String msatpid) {
		this.msatpid = msatpid;
	}

	public String getContractno() {
		return contractno;
	}

	public void setContractno(String contractno) {
		this.contractno = contractno;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getUpside() {
		return upside;
	}

	public void setUpside(String upside) {
		this.upside = upside;
	}
		
	public List<MResource> getAssociates() {
		return associates;
	}

	public void setAssociates(List<MResource> associates) {
		this.associates = associates;
	}
	
	public static void setResourceNameComparator(Comparator<SOWMaster> sowIdComparator) {
		SOWIdComparator = sowIdComparator;
	}

	public static Comparator<SOWMaster> getResourceNameComparator() {
		return SOWIdComparator;
	}

	public static void setContactNameComparator(Comparator<SOWMaster> sowIdComparator) {
		SOWIdComparator = sowIdComparator;
	}
	
	public static Comparator<SOWMaster> SOWIdComparator = new Comparator<SOWMaster>() {

		public int compare(SOWMaster r1, SOWMaster r2) {
			return r1.getId().compareTo(r2.getId());
		}
	};
	

}
