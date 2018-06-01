package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the INITIATIVES database table.
 * 
 */
@Entity
@Table(name="INITIATIVES")
@NamedQuery(name="Initiative.findAll", query="SELECT i FROM Initiative i")
public class Initiative implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="INITIATIVES_INITIATIVEID_GENERATOR", sequenceName="INITIATIVE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INITIATIVES_INITIATIVEID_GENERATOR")
	@Column(name="INITIATIVE_ID")
	private long initiativeId;

	private String analisys;

	private String budget;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	private String expensess;

	private String priority;

	private BigDecimal progress;

	@Temporal(TemporalType.DATE)
	@Column(name="REAL_END_DATE")
	private Date realEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="REAL_START_DATE")
	private Date realStartDate;

	private String recommendations;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	private String title;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="initiative")
	private List<File> files;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Frequency
	@ManyToOne
	@JoinColumn(name="FREQUENCY_ID")
	private Frequency frequency;

	//bi-directional many-to-one association to InitiativeScore
	@OneToMany(mappedBy="initiative")
	private List<InitiativeScore> initiativesScores;

	//bi-directional many-to-one association to InitiativeTeam
	@OneToMany(mappedBy="initiative")
	private List<InitiativeTeam> initiativesTeams;

	//bi-directional many-to-one association to MeasureInitiative
	@OneToMany(mappedBy="initiative")
	private List<MeasureInitiative> measuresInitiatives;

	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="initiative")
	private List<Milestone> milestones;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="initiative")
	private List<Note> notes;

	public Initiative() {
	}

	public long getInitiativeId() {
		return this.initiativeId;
	}

	public void setInitiativeId(long initiativeId) {
		this.initiativeId = initiativeId;
	}

	public String getAnalisys() {
		return this.analisys;
	}

	public void setAnalisys(String analisys) {
		this.analisys = analisys;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
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

	public String getExpensess() {
		return this.expensess;
	}

	public void setExpensess(String expensess) {
		this.expensess = expensess;
	}

	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public BigDecimal getProgress() {
		return this.progress;
	}

	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}

	public Date getRealEndDate() {
		return this.realEndDate;
	}

	public void setRealEndDate(Date realEndDate) {
		this.realEndDate = realEndDate;
	}

	public Date getRealStartDate() {
		return this.realStartDate;
	}

	public void setRealStartDate(Date realStartDate) {
		this.realStartDate = realStartDate;
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
		file.setInitiative(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setInitiative(null);

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

	public List<InitiativeScore> getInitiativesScores() {
		return this.initiativesScores;
	}

	public void setInitiativesScores(List<InitiativeScore> initiativesScores) {
		this.initiativesScores = initiativesScores;
	}

	public InitiativeScore addInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().add(initiativesScore);
		initiativesScore.setInitiative(this);

		return initiativesScore;
	}

	public InitiativeScore removeInitiativesScore(InitiativeScore initiativesScore) {
		getInitiativesScores().remove(initiativesScore);
		initiativesScore.setInitiative(null);

		return initiativesScore;
	}

	public List<InitiativeTeam> getInitiativesTeams() {
		return this.initiativesTeams;
	}

	public void setInitiativesTeams(List<InitiativeTeam> initiativesTeams) {
		this.initiativesTeams = initiativesTeams;
	}

	public InitiativeTeam addInitiativesTeam(InitiativeTeam initiativesTeam) {
		getInitiativesTeams().add(initiativesTeam);
		initiativesTeam.setInitiative(this);

		return initiativesTeam;
	}

	public InitiativeTeam removeInitiativesTeam(InitiativeTeam initiativesTeam) {
		getInitiativesTeams().remove(initiativesTeam);
		initiativesTeam.setInitiative(null);

		return initiativesTeam;
	}

	public List<MeasureInitiative> getMeasuresInitiatives() {
		return this.measuresInitiatives;
	}

	public void setMeasuresInitiatives(List<MeasureInitiative> measuresInitiatives) {
		this.measuresInitiatives = measuresInitiatives;
	}

	public MeasureInitiative addMeasuresInitiative(MeasureInitiative measuresInitiative) {
		getMeasuresInitiatives().add(measuresInitiative);
		measuresInitiative.setInitiative(this);

		return measuresInitiative;
	}

	public MeasureInitiative removeMeasuresInitiative(MeasureInitiative measuresInitiative) {
		getMeasuresInitiatives().remove(measuresInitiative);
		measuresInitiative.setInitiative(null);

		return measuresInitiative;
	}

	public List<Milestone> getMilestones() {
		return this.milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Milestone addMilestone(Milestone milestone) {
		getMilestones().add(milestone);
		milestone.setInitiative(this);

		return milestone;
	}

	public Milestone removeMilestone(Milestone milestone) {
		getMilestones().remove(milestone);
		milestone.setInitiative(null);

		return milestone;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setInitiative(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setInitiative(null);

		return note;
	}

}