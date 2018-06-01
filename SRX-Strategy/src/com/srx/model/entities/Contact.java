package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONTACTS database table.
 * 
 */
@Entity
@Table(name="CONTACTS")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONTACTS_CONTACTID_GENERATOR", sequenceName="CONTACT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTACTS_CONTACTID_GENERATOR")
	@Column(name="CONTACT_ID")
	private long contactId;

	private String address;

	@Column(name="CELL_PHONE")
	private BigDecimal cellPhone;

	private String city;

	@Column(name="COMPANY_ID")
	private BigDecimal companyId;

	private BigDecimal extension;

	private String facebook;

	@Column(name="FIRST_NAME")
	private String firstName;

	private String google;

	private String instagram;

	@Column(name="LAST_NAME")
	private String lastName;

	private String mail;

	private BigDecimal phone;

	@Column(name="\"POSITION\"")
	private String position;

	@Column(name="PUBLIC_ACCOUNT")
	private String publicAccount;

	@Column(name="\"RESUME\"")
	private String resume;

	private String skype;

	private String status;

	private String twitter;

	private String zip;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Organization
	@ManyToOne
	@JoinColumn(name="ORGANIZATION_ID")
	private Organization organization;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	public Contact() {
	}

	public long getContactId() {
		return this.contactId;
	}

	public void setContactId(long contactId) {
		this.contactId = contactId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(BigDecimal cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public BigDecimal getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	public BigDecimal getExtension() {
		return this.extension;
	}

	public void setExtension(BigDecimal extension) {
		this.extension = extension;
	}

	public String getFacebook() {
		return this.facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGoogle() {
		return this.google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public String getInstagram() {
		return this.instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public BigDecimal getPhone() {
		return this.phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPublicAccount() {
		return this.publicAccount;
	}

	public void setPublicAccount(String publicAccount) {
		this.publicAccount = publicAccount;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getSkype() {
		return this.skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTwitter() {
		return this.twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Organization getOrganization() {
		return this.organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}