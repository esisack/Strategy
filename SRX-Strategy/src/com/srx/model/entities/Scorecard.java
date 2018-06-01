package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SCORECARDS database table.
 * 
 */
@Entity
@Table(name="SCORECARDS")
@NamedQuery(name="Scorecard.findAll", query="SELECT s FROM Scorecard s")
public class Scorecard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SCORECARDS_SCORECARDID_GENERATOR", sequenceName="SCORECARD_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SCORECARDS_SCORECARDID_GENERATOR")
	@Column(name="SCORECARD_ID")
	private long scorecardId;

	private String analysis;

	private String description;

	private String mission;

	private String recommendations;

	private String status;

	private String title;

	private String vision;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="scorecard")
	private List<File> files;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="scorecard")
	private List<Note> notes;

	//bi-directional many-to-one association to Objective
	@OneToMany(mappedBy="scorecard")
	private List<Objective> objectives;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Frequency
	@ManyToOne
	@JoinColumn(name="FREQUENCY_ID")
	private Frequency frequency;

	//bi-directional many-to-one association to Scorecard
	@ManyToOne
	@JoinColumn(name="SCORECARD_PARENT")
	private Scorecard scorecard;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="scorecard")
	private List<Scorecard> scorecards;

	public Scorecard() {
	}

	public long getScorecardId() {
		return this.scorecardId;
	}

	public void setScorecardId(long scorecardId) {
		this.scorecardId = scorecardId;
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

	public String getMission() {
		return this.mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

	public String getRecommendations() {
		return this.recommendations;
	}

	public void setRecommendations(String recommendations) {
		this.recommendations = recommendations;
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

	public String getVision() {
		return this.vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public List<File> getFiles() {
		return this.files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public File addFile(File file) {
		getFiles().add(file);
		file.setScorecard(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setScorecard(null);

		return file;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setScorecard(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setScorecard(null);

		return note;
	}

	public List<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public Objective addObjective(Objective objective) {
		getObjectives().add(objective);
		objective.setScorecard(this);

		return objective;
	}

	public Objective removeObjective(Objective objective) {
		getObjectives().remove(objective);
		objective.setScorecard(null);

		return objective;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Frequency getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public Scorecard getScorecard() {
		return this.scorecard;
	}

	public void setScorecard(Scorecard scorecard) {
		this.scorecard = scorecard;
	}

	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setScorecard(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setScorecard(null);

		return scorecard;
	}

}