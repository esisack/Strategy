package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MILESTONES_TEAM database table.
 * 
 */
@Entity
@Table(name="MILESTONES_TEAM")
@NamedQuery(name="MilestoneTeam.findAll", query="SELECT m FROM MilestoneTeam m")
public class MilestoneTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONES_TEAM_MILESTONETEAMID_GENERATOR", sequenceName="MILESTONE_TEAM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONES_TEAM_MILESTONETEAMID_GENERATOR")
	@Column(name="MILESTONE_TEAM_ID")
	private long milestoneTeamId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Milestone
	@ManyToOne
	@JoinColumn(name="MILESTONE_ID")
	private Milestone milestone;

	public MilestoneTeam() {
	}

	public long getMilestoneTeamId() {
		return this.milestoneTeamId;
	}

	public void setMilestoneTeamId(long milestoneTeamId) {
		this.milestoneTeamId = milestoneTeamId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Milestone getMilestone() {
		return this.milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

}