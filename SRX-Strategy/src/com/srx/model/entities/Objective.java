package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OBJECTIVES database table.
 * 
 */
@Entity
@Table(name="OBJECTIVES")
@NamedQuery(name="Objective.findAll", query="SELECT o FROM Objective o")
public class Objective implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="OBJECTIVES_OBJECTIVEID_GENERATOR", sequenceName="OBJECTIVE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBJECTIVES_OBJECTIVEID_GENERATOR")
	@Column(name="OBJECTIVE_ID")
	private long objectiveId;

	private String automatically;

	private String description;

	private String formula;

	private String status;

	private String title;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="objective")
	private List<File> files;

	//bi-directional many-to-one association to Measure
	@OneToMany(mappedBy="objective")
	private List<Measure> measures;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="objective")
	private List<Note> notes;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Frequency
	@ManyToOne
	@JoinColumn(name="FREQUENCY_ID")
	private Frequency frequency;

	//bi-directional many-to-one association to Objective
	@ManyToOne
	@JoinColumn(name="OBJECTIVE_PARENT")
	private Objective objective;

	//bi-directional many-to-one association to Objective
	@OneToMany(mappedBy="objective")
	private List<Objective> objectives;

	//bi-directional many-to-one association to Perspective
	@ManyToOne
	@JoinColumn(name="PERSPECTIVE_ID")
	private Perspective perspective;

	//bi-directional many-to-one association to Scorecard
	@ManyToOne
	@JoinColumn(name="SCORECARD_ID")
	private Scorecard scorecard;

	//bi-directional many-to-one association to ObjectiveScore
	@OneToMany(mappedBy="objective")
	private List<ObjectiveScore> objectivesScores;

	//bi-directional many-to-one association to ObjectiveTeam
	@OneToMany(mappedBy="objective")
	private List<ObjectiveTeam> objectivesTeams;

	public Objective() {
	}

	public long getObjectiveId() {
		return this.objectiveId;
	}

	public void setObjectiveId(long objectiveId) {
		this.objectiveId = objectiveId;
	}

	public String getAutomatically() {
		return this.automatically;
	}

	public void setAutomatically(String automatically) {
		this.automatically = automatically;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormula() {
		return this.formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
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

	public List<File> getFiles() {
		return this.files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	public File addFile(File file) {
		getFiles().add(file);
		file.setObjective(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setObjective(null);

		return file;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setObjective(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setObjective(null);

		return measure;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setObjective(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setObjective(null);

		return note;
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

	public Objective getObjective() {
		return this.objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public List<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public Objective addObjective(Objective objective) {
		getObjectives().add(objective);
		objective.setObjective(this);

		return objective;
	}

	public Objective removeObjective(Objective objective) {
		getObjectives().remove(objective);
		objective.setObjective(null);

		return objective;
	}

	public Perspective getPerspective() {
		return this.perspective;
	}

	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	public Scorecard getScorecard() {
		return this.scorecard;
	}

	public void setScorecard(Scorecard scorecard) {
		this.scorecard = scorecard;
	}

	public List<ObjectiveScore> getObjectivesScores() {
		return this.objectivesScores;
	}

	public void setObjectivesScores(List<ObjectiveScore> objectivesScores) {
		this.objectivesScores = objectivesScores;
	}

	public ObjectiveScore addObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().add(objectivesScore);
		objectivesScore.setObjective(this);

		return objectivesScore;
	}

	public ObjectiveScore removeObjectivesScore(ObjectiveScore objectivesScore) {
		getObjectivesScores().remove(objectivesScore);
		objectivesScore.setObjective(null);

		return objectivesScore;
	}

	public List<ObjectiveTeam> getObjectivesTeams() {
		return this.objectivesTeams;
	}

	public void setObjectivesTeams(List<ObjectiveTeam> objectivesTeams) {
		this.objectivesTeams = objectivesTeams;
	}

	public ObjectiveTeam addObjectivesTeam(ObjectiveTeam objectivesTeam) {
		getObjectivesTeams().add(objectivesTeam);
		objectivesTeam.setObjective(this);

		return objectivesTeam;
	}

	public ObjectiveTeam removeObjectivesTeam(ObjectiveTeam objectivesTeam) {
		getObjectivesTeams().remove(objectivesTeam);
		objectivesTeam.setObjective(null);

		return objectivesTeam;
	}

}