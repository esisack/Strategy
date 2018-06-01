package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEASURES database table.
 * 
 */
@Entity
@Table(name="MEASURES")
@NamedQuery(name="Measure.findAll", query="SELECT m FROM Measure m")
public class Measure implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASURES_MEASUREID_GENERATOR", sequenceName="MEASURE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURES_MEASUREID_GENERATOR")
	@Column(name="MEASURE_ID")
	private long measureId;

	private String automatically;

	private String description;

	private String status;

	private String title;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="measure")
	private List<File> files;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Frequency
	@ManyToOne
	@JoinColumn(name="FREQUENCY_ID")
	private Frequency frequency;

	//bi-directional many-to-one association to Measure
	@ManyToOne
	@JoinColumn(name="MEASURE_PARENT")
	private Measure measure;

	//bi-directional many-to-one association to Measure
	@OneToMany(mappedBy="measure")
	private List<Measure> measures;

	//bi-directional many-to-one association to Objective
	@ManyToOne
	@JoinColumn(name="OBJECTIVE_ID")
	private Objective objective;

	//bi-directional many-to-one association to MeasureInitiative
	@OneToMany(mappedBy="measure")
	private List<MeasureInitiative> measuresInitiatives;

	//bi-directional many-to-one association to MeasureScore
	@OneToMany(mappedBy="measure")
	private List<MeasureScore> measuresScores;

	//bi-directional many-to-one association to MeasureTeam
	@OneToMany(mappedBy="measure")
	private List<MeasureTeam> measuresTeams;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="measure")
	private List<Note> notes;

	public Measure() {
	}

	public long getMeasureId() {
		return this.measureId;
	}

	public void setMeasureId(long measureId) {
		this.measureId = measureId;
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
		file.setMeasure(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setMeasure(null);

		return file;
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

	public Measure getMeasure() {
		return this.measure;
	}

	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setMeasure(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setMeasure(null);

		return measure;
	}

	public Objective getObjective() {
		return this.objective;
	}

	public void setObjective(Objective objective) {
		this.objective = objective;
	}

	public List<MeasureInitiative> getMeasuresInitiatives() {
		return this.measuresInitiatives;
	}

	public void setMeasuresInitiatives(List<MeasureInitiative> measuresInitiatives) {
		this.measuresInitiatives = measuresInitiatives;
	}

	public MeasureInitiative addMeasuresInitiative(MeasureInitiative measuresInitiative) {
		getMeasuresInitiatives().add(measuresInitiative);
		measuresInitiative.setMeasure(this);

		return measuresInitiative;
	}

	public MeasureInitiative removeMeasuresInitiative(MeasureInitiative measuresInitiative) {
		getMeasuresInitiatives().remove(measuresInitiative);
		measuresInitiative.setMeasure(null);

		return measuresInitiative;
	}

	public List<MeasureScore> getMeasuresScores() {
		return this.measuresScores;
	}

	public void setMeasuresScores(List<MeasureScore> measuresScores) {
		this.measuresScores = measuresScores;
	}

	public MeasureScore addMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().add(measuresScore);
		measuresScore.setMeasure(this);

		return measuresScore;
	}

	public MeasureScore removeMeasuresScore(MeasureScore measuresScore) {
		getMeasuresScores().remove(measuresScore);
		measuresScore.setMeasure(null);

		return measuresScore;
	}

	public List<MeasureTeam> getMeasuresTeams() {
		return this.measuresTeams;
	}

	public void setMeasuresTeams(List<MeasureTeam> measuresTeams) {
		this.measuresTeams = measuresTeams;
	}

	public MeasureTeam addMeasuresTeam(MeasureTeam measuresTeam) {
		getMeasuresTeams().add(measuresTeam);
		measuresTeam.setMeasure(this);

		return measuresTeam;
	}

	public MeasureTeam removeMeasuresTeam(MeasureTeam measuresTeam) {
		getMeasuresTeams().remove(measuresTeam);
		measuresTeam.setMeasure(null);

		return measuresTeam;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setMeasure(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setMeasure(null);

		return note;
	}

}