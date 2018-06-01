package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BUSINESS_UNITS database table.
 * 
 */
@Entity
@Table(name="BUSINESS_UNITS")
@NamedQuery(name="BusinessUnit.findAll", query="SELECT b FROM BusinessUnit b")
public class BusinessUnit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESS_UNITS_BUSINESSUNITID_GENERATOR", sequenceName="BUSINESS_UNIT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESS_UNITS_BUSINESSUNITID_GENERATOR")
	@Column(name="BUSINESS_UNIT_ID")
	private long businessUnitId;

	@Column(name="BUSINESS_UNIT_CODE")
	private String businessUnitCode;

	@Column(name="BUSINESS_UNIT_NAME")
	private String businessUnitName;

	private String status;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to InitiativeScore
	@OneToMany(mappedBy="businessUnit")
	private List<InitiativeScore> initiativesScores;

	//bi-directional many-to-one association to MeasureScore
	@OneToMany(mappedBy="businessUnit")
	private List<MeasureScore> measuresScores;

	//bi-directional many-to-one association to ObjectiveScore
	@OneToMany(mappedBy="businessUnit")
	private List<ObjectiveScore> objectivesScores;

	public BusinessUnit() {
	}

	public long getBusinessUnitId() {
		return this.businessUnitId;
	}

	public void setBusinessUnitId(long businessUnitId) {
		this.businessUnitId = businessUnitId;
	}

	public String getBusinessUnitCode() {
		return this.businessUnitCode;
	}

	public void setBusinessUnitCode(String businessUnitCode) {
		this.businessUnitCode = businessUnitCode;
	}

	public String getBusinessUnitName() {
		return this.businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
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
		initiativesScore.setBusinessUnit(this);

		return initiativesScore;
	}

	public InitiativeScore removeInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().remove(initiativesScore);
		initiativesScore.setBusinessUnit(null);

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
		measuresScore.setBusinessUnit(this);

		return measuresScore;
	}

	public MeasureScore removeMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().remove(measuresScore);
		measuresScore.setBusinessUnit(null);

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
		objectivesScore.setBusinessUnit(this);

		return objectivesScore;
	}

	public ObjectiveScore removeObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().remove(objectivesScore);
		objectivesScore.setBusinessUnit(null);

		return objectivesScore;
	}

}