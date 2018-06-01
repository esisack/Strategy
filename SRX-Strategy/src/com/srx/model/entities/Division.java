package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DIVISIONS database table.
 * 
 */
@Entity
@Table(name="DIVISIONS")
@NamedQuery(name="Division.findAll", query="SELECT d FROM Division d")
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DIVISIONS_DIVISIONID_GENERATOR", sequenceName="DIVISION_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIVISIONS_DIVISIONID_GENERATOR")
	@Column(name="DIVISION_ID")
	private long divisionId;

	@Column(name="DIVISION_NAME")
	private String divisionName;

	private String status;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to InitiativeScore
	@OneToMany(mappedBy="division")
	private List<InitiativeScore> initiativesScores;

	//bi-directional many-to-one association to MeasureScore
	@OneToMany(mappedBy="division")
	private List<MeasureScore> measuresScores;

	//bi-directional many-to-one association to ObjectiveScore
	@OneToMany(mappedBy="division")
	private List<ObjectiveScore> objectivesScores;

	public Division() {
	}

	public long getDivisionId() {
		return this.divisionId;
	}

	public void setDivisionId(long divisionId) {
		this.divisionId = divisionId;
	}

	public String getDivisionName() {
		return this.divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<InitiativeScore> getInitiativesScores() {
		return this.initiativesScores;
	}

	public void setInitiativesScores(List<InitiativeScore> initiativesScores) {
		this.initiativesScores = initiativesScores;
	}

	public InitiativeScore addInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().add(initiativesScore);
		initiativesScore.setDivision(this);

		return initiativesScore;
	}

	public InitiativeScore removeInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().remove(initiativesScore);
		initiativesScore.setDivision(null);

		return initiativesScore;
	}

	public List<MeasureScore> getMeasuresScores() {
		return this.measuresScores;
	}

	public void setMeasuresScores(List<MeasureScore> measuresScores) {
		this.measuresScores = measuresScores;
	}

	public MeasureScore addMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().add(measuresScore);
		measuresScore.setDivision(this);

		return measuresScore;
	}

	public MeasureScore removeMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().remove(measuresScore);
		measuresScore.setDivision(null);

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
		objectivesScore.setDivision(this);

		return objectivesScore;
	}

	public ObjectiveScore removeObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().remove(objectivesScore);
		objectivesScore.setDivision(null);

		return objectivesScore;
	}

}