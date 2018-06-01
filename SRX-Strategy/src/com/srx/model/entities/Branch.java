package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BRANCHES database table.
 * 
 */
@Entity
@Table(name="BRANCHES")
@NamedQuery(name="Branch.findAll", query="SELECT b FROM Branch b")
public class Branch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BRANCHES_BRANCHID_GENERATOR", sequenceName="BRANCH_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BRANCHES_BRANCHID_GENERATOR")
	@Column(name="BRANCH_ID")
	private long branchId;

	private String address;

	@Column(name="BRANCH_NAME")
	private String branchName;

	private String status;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	//bi-directional many-to-one association to InitiativeScore
	@OneToMany(mappedBy="branch")
	private List<InitiativeScore> initiativesScores;

	//bi-directional many-to-one association to MeasureScore
	@OneToMany(mappedBy="branch")
	private List<MeasureScore> measuresScores;

	//bi-directional many-to-one association to ObjectiveScore
	@OneToMany(mappedBy="branch")
	private List<ObjectiveScore> objectivesScores;

	public Branch() {
	}

	public long getBranchId() {
		return this.branchId;
	}

	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<InitiativeScore> getInitiativesScores() {
		return this.initiativesScores;
	}

	public void setInitiativesScores(List<InitiativeScore> initiativesScores) {
		this.initiativesScores = initiativesScores;
	}

	public InitiativeScore addInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().add(initiativesScore);
		initiativesScore.setBranch(this);

		return initiativesScore;
	}

	public InitiativeScore removeInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().remove(initiativesScore);
		initiativesScore.setBranch(null);

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
		measuresScore.setBranch(this);

		return measuresScore;
	}

	public MeasureScore removeMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().remove(measuresScore);
		measuresScore.setBranch(null);

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
		objectivesScore.setBranch(this);

		return objectivesScore;
	}

	public ObjectiveScore removeObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().remove(objectivesScore);
		objectivesScore.setBranch(null);

		return objectivesScore;
	}

}