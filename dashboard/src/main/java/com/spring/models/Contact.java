package com.spring.models;

import java.util.Comparator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="vp")
	private String vp;
	@Column(name="svp")
	private String svp;
	@Column(name="director")
	private String director;
	@Column(name="senior_manager")
	private String senior_manager;
	@Column(name="department_name")
	private String department_name;
	@Column(name="emailid")
	private String emailid;
	@Column(name="emailtosendinvoice")
	private String emailtosendinvoice;
	@Column(name = "user_email", nullable = false)
	private String user;
	
	// required for bad request (JSON Error/Parsing Error)
	public Contact() {
		super();
	}

	public String getVp() {
		return vp;
	}

	public void setVp(String vp) {
		this.vp = vp;
	}

	public String getSvp() {
		return svp;
	}

	public void setSvp(String svp) {
		this.svp = svp;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSenior_manager() {
		return senior_manager;
	}

	public void setSenior_manager(String senior_manager) {
		this.senior_manager = senior_manager;
	}

	public String getDepartment_name() {
		return department_name;
	}
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getEmailtosendinvoice() {
		return emailtosendinvoice;
	}

	public void setEmailtosendinvoice(String emailtosendinvoice) {
		this.emailtosendinvoice = emailtosendinvoice;
	}

	public static Comparator<Contact> getContactNameComparator() {
		return ContactNameComparator;
	}

	public static void setContactNameComparator(Comparator<Contact> contactNameComparator) {
		ContactNameComparator = contactNameComparator;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + vp + ", email=" + emailid + ", senior manager=" + senior_manager + "]";
	}

	public static Comparator<Contact> ContactNameComparator = new Comparator<Contact>() {

		public int compare(Contact c1, Contact c2) {
			return c1.getId().compareTo(c2.getId());
		}
	};

}
