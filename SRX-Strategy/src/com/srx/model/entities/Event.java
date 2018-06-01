package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the "EVENTS" database table.
 * 
 */
@Entity
@Table(name="\"EVENTS\"")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EVENTS_EVENTID_GENERATOR", sequenceName="EVENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EVENTS_EVENTID_GENERATOR")
	@Column(name="EVENT_ID")
	private long eventId;

	@Column(name="ALL_DAY")
	private String allDay;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="PUBLIC_EVENT")
	private String publicEvent;

	private String recurring;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	private String title;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Issue
	@ManyToOne
	@JoinColumn(name="ISSUE_ID")
	private Issue issue;

	public Event() {
	}

	public long getEventId() {
		return this.eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getAllDay() {
		return this.allDay;
	}

	public void setAllDay(String allDay) {
		this.allDay = allDay;
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

	public String getPublicEvent() {
		return this.publicEvent;
	}

	public void setPublicEvent(String publicEvent) {
		this.publicEvent = publicEvent;
	}

	public String getRecurring() {
		return this.recurring;
	}

	public void setRecurring(String recurring) {
		this.recurring = recurring;
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

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Issue getIssue() {
		return this.issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}