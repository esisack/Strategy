package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the INITIATIVES_TEAM database table.
 * 
 */
@Entity
@Table(name="INITIATIVES_TEAM")
@NamedQuery(name="InitiativeTeam.findAll", query="SELECT i FROM InitiativeTeam i")
public class InitiativeTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INITIATIVES_TEAM_INITIATIVETEAMID_GENERATOR", sequenceName="INITIATIVE_TEAM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INITIATIVES_TEAM_INITIATIVETEAMID_GENERATOR")
	@Column(name="INITIATIVE_TEAM_ID")
	private long initiativeTeamId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Initiative
	@ManyToOne
	@JoinColumn(name="INITIATIVE_ID")
	private Initiative initiative;

	public InitiativeTeam() {
	}

	public long getInitiativeTeamId() {
		return this.initiativeTeamId;
	}

	public void setInitiativeTeamId(long initiativeTeamId) {
		this.initiativeTeamId = initiativeTeamId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Initiative getInitiative() {
		return this.initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

}