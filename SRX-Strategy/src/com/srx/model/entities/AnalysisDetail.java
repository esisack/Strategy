package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ANALYSIS_DETAIL database table.
 * 
 */
@Entity
@Table(name="ANALYSIS_DETAIL")
@NamedQuery(name="AnalysisDetail.findAll", query="SELECT a FROM AnalysisDetail a")
public class AnalysisDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANALYSIS_DETAIL_ANALYSISDETAILID_GENERATOR", sequenceName="ANALYSIS_DETAIL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALYSIS_DETAIL_ANALYSISDETAILID_GENERATOR")
	@Column(name="ANALYSIS_DETAIL_ID")
	private long analysisDetailId;

	private String issue;

	private String score;

	@Column(name="\"VALUE\"")
	private BigDecimal value;

	private BigDecimal weight;

	//bi-directional many-to-one association to Analysis
	@ManyToOne
	@JoinColumn(name="ANALYSIS_ID")
	private Analysis analysi;

	//bi-directional many-to-one association to Factor
	@ManyToOne
	@JoinColumn(name="FACTOR_ID")
	private Factor factor;

	public AnalysisDetail() {
	}

	public long getAnalysisDetailId() {
		return this.analysisDetailId;
	}

	public void setAnalysisDetailId(long analysisDetailId) {
		this.analysisDetailId = analysisDetailId;
	}

	public String getIssue() {
		return this.issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public BigDecimal getValue() {
		return this.value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Analysis getAnalysi() {
		return this.analysi;
	}

	public void setAnalysi(Analysis analysi) {
		this.analysi = analysi;
	}

	public Factor getFactor() {
		return this.factor;
	}

	public void setFactor(Factor factor) {
		this.factor = factor;
	}

}