package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ISSUES database table.
 * 
 */
@Entity
@Table(name="ISSUES")
@NamedQuery(name="Issue.findAll", query="SELECT i FROM Issue i")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ISSUES_ISSUEID_GENERATOR", sequenceName="ISSUE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ISSUES_ISSUEID_GENERATOR")
	@Column(name="ISSUE_ID")
	private String issueId;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	private String priority;

	private BigDecimal progress;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	private String title;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="issue")
	private List<Event> events;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="OWNER_ID")
	private Employee employee1;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="MANAGER_ID")
	private Employee employee2;

	public Issue() {
	}

	public String getIssueId() {
		return this.issueId;
	}

	public void setIssueId(String issueId) {
		this.issueId = issueId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public BigDecimal getProgress() {
		return this.progress;
	}

	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setIssue(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setIssue(null);

		return event;
	}

	public Employee getEmployee1() {
		return this.employee1;
	}

	public void setEmployee1(Employee employee1) {
		this.employee1 = employee1;
	}

	public Employee getEmployee2() {
		return this.employee2;
	}

	public void setEmployee2(Employee employee2) {
		this.employee2 = employee2;
	}

}