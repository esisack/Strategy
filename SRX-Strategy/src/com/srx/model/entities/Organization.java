package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ORGANIZATIONS database table.
 * 
 */
@Entity
@Table(name="ORGANIZATIONS")
@NamedQuery(name="Organization.findAll", query="SELECT o FROM Organization o")
public class Organization implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ORGANIZATIONS_ORGANIZATIONID_GENERATOR", sequenceName="ORGANIZATION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ORGANIZATIONS_ORGANIZATIONID_GENERATOR")
	@Column(name="ORGANIZATION_ID")
	private long organizationId;

	private String address;

	@Column(name="CELL_PHONE")
	private BigDecimal cellPhone;

	private String city;

	private String contact;

	private BigDecimal extension;

	private String mail;

	@Column(name="ORGANIZATION_CODE")
	private String organizationCode;

	@Column(name="ORGANIZATION_NAME")
	private String organizationName;

	private BigDecimal phone;

	private String status;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="organization")
	private List<Contact> contacts;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	public Organization() {
	}

	public long getOrganizationId() {
		return this.organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
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

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public BigDecimal getExtension() {
		return this.extension;
	}

	public void setExtension(BigDecimal extension) {
		this.extension = extension;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getOrganizationCode() {
		return this.organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public BigDecimal getPhone() {
		return this.phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setOrganization(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setOrganization(null);

		return contact;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}