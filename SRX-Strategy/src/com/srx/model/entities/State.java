package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the STATES database table.
 * 
 */
@Entity
@Table(name="STATES")
@NamedQuery(name="State.findAll", query="SELECT s FROM State s")
public class State implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="STATES_STATEID_GENERATOR", sequenceName="STATE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATES_STATEID_GENERATOR")
	@Column(name="STATE_ID")
	private long stateId;

	@Column(name="STATE_CODE")
	private String stateCode;

	@Column(name="STATE_NAME")
	private String stateName;

	private String status;

	//bi-directional many-to-one association to Branch
	@OneToMany(mappedBy="state")
	private List<Branch> branches;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="state")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="state")
	private List<Employee> employees;

	//bi-directional many-to-one association to MeasureScore
	@OneToMany(mappedBy="state")
	private List<MeasureScore> measuresScores;

	//bi-directional many-to-one association to ObjectiveScore
	@OneToMany(mappedBy="state")
	private List<ObjectiveScore> objectivesScores;

	//bi-directional many-to-one association to Organization
	@OneToMany(mappedBy="state")
	private List<Organization> organizations;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	public State() {
	}

	public long getStateId() {
		return this.stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateCode() {
		return this.stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return this.stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setState(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setState(null);

		return branch;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setState(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setState(null);

		return contact;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setState(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setState(null);

		return employee;
	}

	public List<MeasureScore> getMeasuresScores() {
		return this.measuresScores;
	}

	public void setMeasuresScores(List<MeasureScore> measuresScores) {
		this.measuresScores = measuresScores;
	}

	public MeasureScore addMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().add(measuresScore);
		measuresScore.setState(this);

		return measuresScore;
	}

	public MeasureScore removeMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().remove(measuresScore);
		measuresScore.setState(null);

		return measuresScore;
	}

	public List<ObjectiveScore> getObjectivesScores() {
		return this.objectivesScores;
	}

	public void setObjectivesScores(List<ObjectiveScore> objectivesScores) {
		this.objectivesScores = objectivesScores;
	}

	public ObjectiveScore addObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().add(objectivesScore);
		objectivesScore.setState(this);

		return objectivesScore;
	}

	public ObjectiveScore removeObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().remove(objectivesScore);
		objectivesScore.setState(null);

		return objectivesScore;
	}

	public List<Organization> getOrganizations() {
		return this.organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public Organization addOrganization(Organization organization) {
		getOrganizations().add(organization);
		organization.setState(this);

		return organization;
	}

	public Organization removeOrganization(Organization organization) {
		getOrganizations().remove(organization);
		organization.setState(null);

		return organization;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}