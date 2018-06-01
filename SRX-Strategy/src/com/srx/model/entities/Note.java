package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the NOTES database table.
 * 
 */
@Entity
@Table(name="NOTES")
@NamedQuery(name="Note.findAll", query="SELECT n FROM Note n")
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NOTES_NOTEID_GENERATOR", sequenceName="NOTE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTES_NOTEID_GENERATOR")
	@Column(name="NOTE_ID")
	private long noteId;

	private String description;

	private String status;

	private String title;

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

	public Note() {
	}

	public long getNoteId() {
		return this.noteId;
	}

	public void setNoteId(long noteId) {
		this.noteId = noteId;
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