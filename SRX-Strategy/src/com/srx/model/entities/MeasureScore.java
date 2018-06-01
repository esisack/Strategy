package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MEASURES_SCORE database table.
 * 
 */
@Entity
@Table(name="MEASURES_SCORE")
@NamedQuery(name="MeasureScore.findAll", query="SELECT m FROM MeasureScore m")
public class MeasureScore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASURES_SCORE_MEASURESCOREID_GENERATOR", sequenceName="MEASURE_SCORE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURES_SCORE_MEASURESCOREID_GENERATOR")
	@Column(name="MEASURE_SCORE_ID")
	private long measureScoreId;

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

	//bi-directional many-to-one association to Measure
	@ManyToOne
	@JoinColumn(name="MEASURE_ID")
	private Measure measure;

	//bi-directional many-to-one association to State
	@ManyToOne
	@JoinColumn(name="STATE_ID")
	private State state;

	public MeasureScore() {
	}

	public long getMeasureScoreId() {
		return this.measureScoreId;
	}

	public void setMeasureScoreId(long measureScoreId) {
		this.measureScoreId = measureScoreId;
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

	public Measure getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

}