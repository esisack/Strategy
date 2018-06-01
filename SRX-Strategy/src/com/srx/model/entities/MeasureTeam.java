package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MEASURES_TEAM database table.
 * 
 */
@Entity
@Table(name="MEASURES_TEAM")
@NamedQuery(name="MeasureTeam.findAll", query="SELECT m FROM MeasureTeam m")
public class MeasureTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASURES_TEAM_MEASURETEAMID_GENERATOR", sequenceName="MEASURE_TEAM_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURES_TEAM_MEASURETEAMID_GENERATOR")
	@Column(name="MEASURE_TEAM_ID")
	private long measureTeamId;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Measure
	@ManyToOne
	@JoinColumn(name="MEASURE_ID")
	private Measure measure;

	public MeasureTeam() {
	}

	public long getMeasureTeamId() {
		return this.measureTeamId;
	}

	public void setMeasureTeamId(long measureTeamId) {
		this.measureTeamId = measureTeamId;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Measure getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

}