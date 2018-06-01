package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ANALYSIS database table.
 * 
 */
@Entity
@NamedQuery(name="Analysis.findAll", query="SELECT a FROM Analysis a")
public class Analysis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANALYSIS_ANALYSISID_GENERATOR", sequenceName="ANALYSIS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALYSIS_ANALYSISID_GENERATOR")
	@Column(name="ANALYSIS_ID")
	private long analysisId;

	private String analysis;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	private String recommendations;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	//bi-directional many-to-one association to Tool
	@ManyToOne
	@JoinColumn(name="TOOL_ID")
	private Tool tool;

	//bi-directional many-to-one association to AnalysisDetail
	@OneToMany(mappedBy="analysi")
	private List<AnalysisDetail> analysisDetails;

	public Analysis() {
	}

	public long getAnalysisId() {
		return this.analysisId;
	}

	public void setAnalysisId(long analysisId) {
		this.analysisId = analysisId;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRecommendations() {
		return this.recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Tool getTool() {
		return this.tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public List<AnalysisDetail> getAnalysisDetails() {
		return this.analysisDetails;
	}

	public void setAnalysisDetails(List<AnalysisDetail> analysisDetails) {
		this.analysisDetails = analysisDetails;
	}

	public AnalysisDetail addAnalysisDetail(AnalysisDetail analysisDetail) {
		getAnalysisDetails().add(analysisDetail);
		analysisDetail.setAnalysi(this);

		return analysisDetail;
	}

	public AnalysisDetail removeAnalysisDetail(AnalysisDetail analysisDetail) {
		getAnalysisDetails().remove(analysisDetail);
		analysisDetail.setAnalysi(null);

		return analysisDetail;
	}

}