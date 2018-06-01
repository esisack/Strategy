package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the FACTORS database table.
 * 
 */
@Entity
@Table(name="FACTORS")
@NamedQuery(name="Factor.findAll", query="SELECT f FROM Factor f")
public class Factor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FACTORS_FACTORID_GENERATOR", sequenceName="FACTOR_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACTORS_FACTORID_GENERATOR")
	@Column(name="FACTOR_ID")
	private long factorId;

	@Column(name="FACTOR_NAME")
	private String factorName;

	@Column(name="REPORT_ORDER")
	private BigDecimal reportOrder;

	//bi-directional many-to-one association to AnalysisDetail
	@OneToMany(mappedBy="factor")
	private List<AnalysisDetail> analysisDetails;

	//bi-directional many-to-one association to Tool
	@ManyToOne
	@JoinColumn(name="TOOL_ID")
	private Tool tool;

	public Factor() {
	}

	public long getFactorId() {
		return this.factorId;
	}

	public void setFactorId(long factorId) {
		this.factorId = factorId;
	}

	public String getFactorName() {
		return this.factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public BigDecimal getReportOrder() {
		return this.reportOrder;
	}

	public void setReportOrder(BigDecimal reportOrder) {
		this.reportOrder = reportOrder;
	}

	public List<AnalysisDetail> getAnalysisDetails() {
		return this.analysisDetails;
	}

	public void setAnalysisDetails(List<AnalysisDetail> analysisDetails) {
		this.analysisDetails = analysisDetails;
	}

	public AnalysisDetail addAnalysisDetail(AnalysisDetail analysisDetail) {
		getAnalysisDetails().add(analysisDetail);
		analysisDetail.setFactor(this);

		return analysisDetail;
	}

	public AnalysisDetail removeAnalysisDetail(AnalysisDetail analysisDetail) {
		getAnalysisDetails().remove(analysisDetail);
		analysisDetail.setFactor(null);

		return analysisDetail;
	}

	public Tool getTool() {
		return this.tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

}