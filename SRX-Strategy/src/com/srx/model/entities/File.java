package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FILES database table.
 * 
 */
@Entity
@Table(name="FILES")
@NamedQuery(name="File.findAll", query="SELECT f FROM File f")
public class File implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FILES_FILEID_GENERATOR", sequenceName="FILE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FILES_FILEID_GENERATOR")
	@Column(name="FILE_ID")
	private long fileId;

	private String description;

	private String status;

	private String title;

	private String url;

	//bi-directional many-to-one association to Initiative
	@ManyToOne
	@JoinColumn(name="INITIATIVE_ID")
	private Initiative initiative;

	//bi-directional many-to-one association to Measure
	@ManyToOne
	@JoinColumn(name="MEASURE_ID")
	private Measure measure;

	//bi-directional many-to-one association to Milestone
	@ManyToOne
	@JoinColumn(name="MILESTONE_ID")
	private Milestone milestone;

	//bi-directional many-to-one association to Objective
	@ManyToOne
	@JoinColumn(name="OBJECTIVE_ID")
	private Objective objective;

	//bi-directional many-to-one association to Scorecard
	@ManyToOne
	@JoinColumn(name="SCORECARD_ID")
	private Scorecard scorecard;

	public File() {
	}

	public long getFileId() {
		return this.fileId;
	}

	public void setFileId(long fileId) {
		this.fileId = fileId;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Initiative getInitiative() {
		return this.initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

	public Measure getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public Milestone getMilestone() {
		return this.milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public Objective getObjective() {
		return this.objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public Scorecard getScorecard() {
		return this.scorecard;
	}

	public void setScorecard(Scorecard scorecard) {
		this.scorecard = scorecard;
	}

}