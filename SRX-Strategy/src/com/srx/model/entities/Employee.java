package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEES_EMPLOYEEID_GENERATOR", sequenceName="EMPLOYEE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEES_EMPLOYEEID_GENERATOR")
	@Column(name="EMPLOYEE_ID")
	private long employeeId;

	private String address;

	@Column(name="CELL_PHONE")
	private BigDecimal cellPhone;

	private String city;

	@Column(name="EMPLOYEE_CODE")
	private String employeeCode;

	private String enabled;

	private BigDecimal extension;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	private String mail;

	@Column(name="OTHER_PHONE")
	private BigDecimal otherPhone;

	private String password;

	private BigDecimal phone;

	private String status;

	@Column(name="USER_NAME")
	private String userName;

	//bi-directional many-to-one association to BusinessPlan
	@OneToMany(mappedBy="employee")
	private List<BusinessPlan> businessPlans;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="employee")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="COUNTRY_ID")
	private Country country;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="JOB_ID")
	private Job job;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="employee")
	private List<Event> events;

	//bi-directional many-to-one association to Initiative
	@OneToMany(mappedBy="employee")
	private List<Initiative> initiatives;

	//bi-directional many-to-one association to InitiativeTeam
	@OneToMany(mappedBy="employee")
	private List<InitiativeTeam> initiativesTeams;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="employee1")
	private List<Issue> issues1;

	//bi-directional many-to-one association to Issue
	@OneToMany(mappedBy="employee2")
	private List<Issue> issues2;

	//bi-directional many-to-one association to Measure
	@OneToMany(mappedBy="employee")
	private List<Measure> measures;

	//bi-directional many-to-one association to MeasureTeam
	@OneToMany(mappedBy="employee")
	private List<MeasureTeam> measuresTeams;

	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="employee")
	private List<Milestone> milestones;

	//bi-directional many-to-one association to MilestoneTeam
	@OneToMany(mappedBy="employee")
	private List<MilestoneTeam> milestonesTeams;

	//bi-directional many-to-one association to Objective
	@OneToMany(mappedBy="employee")
	private List<Objective> objectives;

	//bi-directional many-to-one association to ObjectiveTeam
	@OneToMany(mappedBy="employee")
	private List<ObjectiveTeam> objectivesTeams;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="employee")
	private List<Scorecard> scorecards;

	public Employee() {
	}

	public long getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public String getEmployeeCode() {
		return this.employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public BigDecimal getExtension() {
		return this.extension;
	}

	public void setExtension(BigDecimal extension) {
		this.extension = extension;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public BigDecimal getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(BigDecimal otherPhone) {
		this.otherPhone = otherPhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<BusinessPlan> getBusinessPlans() {
		return this.businessPlans;
	}

	public void setBusinessPlans(List<BusinessPlan> businessPlans) {
		this.businessPlans = businessPlans;
	}

	public BusinessPlan addBusinessPlan(BusinessPlan businessPlan) {
		getBusinessPlans().add(businessPlan);
		businessPlan.setEmployee(this);

		return businessPlan;
	}

	public BusinessPlan removeBusinessPlan(BusinessPlan businessPlan) {
		getBusinessPlans().remove(businessPlan);
		businessPlan.setEmployee(null);

		return businessPlan;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setEmployee(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setEmployee(null);

		return contact;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setEmployee(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setEmployee(null);

		return event;
	}

	public List<Initiative> getInitiatives() {
		return this.initiatives;
	}

	public void setInitiatives(List<Initiative> initiatives) {
		this.initiatives = initiatives;
	}

	public Initiative addInitiative(Initiative initiative) {
		getInitiatives().add(initiative);
		initiative.setEmployee(this);

		return initiative;
	}

	public Initiative removeInitiative(Initiative initiative) {
		getInitiatives().remove(initiative);
		initiative.setEmployee(null);

		return initiative;
	}

	public List<InitiativeTeam> getInitiativesTeams() {
		return this.initiativesTeams;
	}

	public void setInitiativesTeams(List<InitiativeTeam> initiativesTeams) {
		this.initiativesTeams = initiativesTeams;
	}

	public InitiativeTeam addInitiativesTeam(InitiativeTeam initiativesTeam) {
		getInitiativesTeams().add(initiativesTeam);
		initiativesTeam.setEmployee(this);

		return initiativesTeam;
	}

	public InitiativeTeam removeInitiativesTeam(InitiativeTeam initiativesTeam) {
		getInitiativesTeams().remove(initiativesTeam);
		initiativesTeam.setEmployee(null);

		return initiativesTeam;
	}

	public List<Issue> getIssues1() {
		return this.issues1;
	}

	public void setIssues1(List<Issue> issues1) {
		this.issues1 = issues1;
	}

	public Issue addIssues1(Issue issues1) {
		getIssues1().add(issues1);
		issues1.setEmployee1(this);

		return issues1;
	}

	public Issue removeIssues1(Issue issues1) {
		getIssues1().remove(issues1);
		issues1.setEmployee1(null);

		return issues1;
	}

	public List<Issue> getIssues2() {
		return this.issues2;
	}

	public void setIssues2(List<Issue> issues2) {
		this.issues2 = issues2;
	}

	public Issue addIssues2(Issue issues2) {
		getIssues2().add(issues2);
		issues2.setEmployee2(this);

		return issues2;
	}

	public Issue removeIssues2(Issue issues2) {
		getIssues2().remove(issues2);
		issues2.setEmployee2(null);

		return issues2;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setEmployee(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setEmployee(null);

		return measure;
	}

	public List<MeasureTeam> getMeasuresTeams() {
		return this.measuresTeams;
	}

	public void setMeasuresTeams(List<MeasureTeam> measuresTeams) {
		this.measuresTeams = measuresTeams;
	}

	public MeasureTeam addMeasuresTeam(MeasureTeam measuresTeam) {
		getMeasuresTeams().add(measuresTeam);
		measuresTeam.setEmployee(this);

		return measuresTeam;
	}

	public MeasureTeam removeMeasuresTeam(MeasureTeam measuresTeam) {
		getMeasuresTeams().remove(measuresTeam);
		measuresTeam.setEmployee(null);

		return measuresTeam;
	}

	public List<Milestone> getMilestones() {
		return this.milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Milestone addMilestone(Milestone milestone) {
		getMilestones().add(milestone);
		milestone.setEmployee(this);

		return milestone;
	}

	public Milestone removeMilestone(Milestone milestone) {
		getMilestones().remove(milestone);
		milestone.setEmployee(null);

		return milestone;
	}

	public List<MilestoneTeam> getMilestonesTeams() {
		return this.milestonesTeams;
	}

	public void setMilestonesTeams(List<MilestoneTeam> milestonesTeams) {
		this.milestonesTeams = milestonesTeams;
	}

	public MilestoneTeam addMilestonesTeam(MilestoneTeam milestonesTeam) {
		getMilestonesTeams().add(milestonesTeam);
		milestonesTeam.setEmployee(this);

		return milestonesTeam;
	}

	public MilestoneTeam removeMilestonesTeam(MilestoneTeam milestonesTeam) {
		getMilestonesTeams().remove(milestonesTeam);
		milestonesTeam.setEmployee(null);

		return milestonesTeam;
	}

	public List<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public Objective addObjective(Objective objective) {
		getObjectives().add(objective);
		objective.setEmployee(this);

		return objective;
	}

	public Objective removeObjective(Objective objective) {
		getObjectives().remove(objective);
		objective.setEmployee(null);

		return objective;
	}

	public List<ObjectiveTeam> getObjectivesTeams() {
		return this.objectivesTeams;
	}

	public void setObjectivesTeams(List<ObjectiveTeam> objectivesTeams) {
		this.objectivesTeams = objectivesTeams;
	}

	public ObjectiveTeam addObjectivesTeam(ObjectiveTeam objectivesTeam) {
		getObjectivesTeams().add(objectivesTeam);
		objectivesTeam.setEmployee(this);

		return objectivesTeam;
	}

	public ObjectiveTeam removeObjectivesTeam(ObjectiveTeam objectivesTeam) {
		getObjectivesTeams().remove(objectivesTeam);
		objectivesTeam.setEmployee(null);

		return objectivesTeam;
	}

	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setEmployee(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setEmployee(null);

		return scorecard;
	}

}