package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OBJECTIVES_TEAM database table.
 * 
 */
@Entity
@Table(name="OBJECTIVES_TEAM")
@NamedQuery(name="ObjectiveTeam.findAll", query="SELECT o FROM ObjectiveTeam o")
public class ObjectiveTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBJECTIVES_TEAM_OBJECTIVETEAMID_GENERATOR", sequenceName="OBJECTIVE_TEAM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBJECTIVES_TEAM_OBJECTIVETEAMID_GENERATOR")
	@Column(name="OBJECTIVE_TEAM_ID")
	private long objectiveTeamId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Objective
	@ManyToOne
	@JoinColumn(name="OBJECTIVE_ID")
	private Objective objective;

	public ObjectiveTeam() {
	}

	public long getObjectiveTeamId() {
		return this.objectiveTeamId;
	}

	public void setObjectiveTeamId(long objectiveTeamId) {
		this.objectiveTeamId = objectiveTeamId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Objective getObjective() {
		return this.objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

}