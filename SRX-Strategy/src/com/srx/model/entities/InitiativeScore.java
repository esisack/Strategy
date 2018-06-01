package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INITIATIVES_SCORES database table.
 * 
 */
@Entity
@Table(name="INITIATIVES_SCORES")
@NamedQuery(name="InitiativeScore.findAll", query="SELECT i FROM InitiativeScore i")
public class InitiativeScore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INITIATIVES_SCORES_INITIATIVESCOREID_GENERATOR", sequenceName="INITIATIVE_SCORE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INITIATIVES_SCORES_INITIATIVESCOREID_GENERATOR")
	@Column(name="INITIATIVE_SCORE_ID")
	private long initiativeScoreId;

	@Column(name="ABOVE_TARGET")
	private BigDecimal aboveTarget;

	private String analysis;

	@Column(name="BELOW_PLAN")
	private BigDecimal belowPlan;

	private BigDecimal caution;

	private String period;

	private String recommendations;

	@Column(name="REPORT_ORDER")
	private BigDecimal reportOrder;

	private BigDecimal score;

	private BigDecimal target;

	//bi-directional many-to-one association to Branch
	@ManyToOne
	@JoinColumn(name="BRANCH_ID")
	private Branch branch;

	//bi-directional many-to-one association to BusinessUnit
	@ManyToOne
	@JoinColumn(name="BUSINESS_UNIT_ID")
	private BusinessUnit businessUnit;

	//bi-directional many-to-one association to Division
	@ManyToOne
	@JoinColumn(name="DIVISION_ID")
	private Division division;

	//bi-directional many-to-one association to Initiative
	@ManyToOne
	@JoinColumn(name="INITIATIVE_ID")
	private Initiative initiative;

	public InitiativeScore() {
	}

	public long getInitiativeScoreId() {
		return this.initiativeScoreId;
	}

	public void setInitiativeScoreId(long initiativeScoreId) {
		this.initiativeScoreId = initiativeScoreId;
	}

	public BigDecimal getAboveTarget() {
		return this.aboveTarget;
	}

	public void setAboveTarget(BigDecimal aboveTarget) {
		this.aboveTarget = aboveTarget;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public BigDecimal getBelowPlan() {
		return this.belowPlan;
	}

	public void setBelowPlan(BigDecimal belowPlan) {
		this.belowPlan = belowPlan;
	}

	public BigDecimal getCaution() {
		return this.caution;
	}

	public void setCaution(BigDecimal caution) {
		this.caution = caution;
	}

	public String getPeriod() {
		return this.period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getRecommendations() {
		return this.recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public BigDecimal getReportOrder() {
		return this.reportOrder;
	}

	public void setReportOrder(BigDecimal reportOrder) {
		this.reportOrder = reportOrder;
	}

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public BigDecimal getTarget() {
		return this.target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public BusinessUnit getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}

	public Division getDivision() {
		return this.division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	public Initiative getInitiative() {
		return this.initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

}