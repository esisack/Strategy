package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TOOLS database table.
 * 
 */
@Entity
@Table(name="TOOLS")
@NamedQuery(name="Tool.findAll", query="SELECT t FROM Tool t")
public class Tool implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TOOLS_TOOLID_GENERATOR", sequenceName="TOOL_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TOOLS_TOOLID_GENERATOR")
	@Column(name="TOOL_ID")
	private long toolId;

	private String description;

	private String status;

	@Column(name="TOOL_NAME")
	private String toolName;

	//bi-directional many-to-one association to Analysis
	@OneToMany(mappedBy="tool")
	private List<Analysis> analysis;

	//bi-directional many-to-one association to Factor
	@OneToMany(mappedBy="tool")
	private List<Factor> factors;

	public Tool() {
	}

	public long getToolId() {
		return this.toolId;
	}

	public void setToolId(long toolId) {
		this.toolId = toolId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getToolName() {
		return this.toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public List<Analysis> getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(List<Analysis> analysis) {
		this.analysis = analysis;
	}

	public Analysis addAnalysi(Analysis analysi) {
		getAnalysis().add(analysi);
		analysi.setTool(this);

		return analysi;
	}

	public Analysis removeAnalysi(Analysis analysi) {
		getAnalysis().remove(analysi);
		analysi.setTool(null);

		return analysi;
	}

	public List<Factor> getFactors() {
		return this.factors;
	}

	public void setFactors(List<Factor> factors) {
		this.factors = factors;
	}

	public Factor addFactor(Factor factor) {
		getFactors().add(factor);
		factor.setTool(this);

		return factor;
	}

	public Factor removeFactor(Factor factor) {
		getFactors().remove(factor);
		factor.setTool(null);

		return factor;
	}

}