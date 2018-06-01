package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MILESTONES database table.
 * 
 */
@Entity
@Table(name="MILESTONES")
@NamedQuery(name="Milestone.findAll", query="SELECT m FROM Milestone m")
public class Milestone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MILESTONES_MILESTONEID_GENERATOR", sequenceName="MILESTONE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MILESTONES_MILESTONEID_GENERATOR")
	@Column(name="MILESTONE_ID")
	private long milestoneId;

	private String analysis;

	private String asumptions;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	private BigDecimal progress;

	@Temporal(TemporalType.DATE)
	@Column(name="REAL_END_DATE")
	private Date realEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="REAL_START_DATE")
	private Date realStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	private String title;

	//bi-directional many-to-one association to File
	@OneToMany(mappedBy="milestone")
	private List<File> files;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	//bi-directional many-to-one association to Initiative
	@ManyToOne
	@JoinColumn(name="INITIATIVE_ID")
	private Initiative initiative;

	//bi-directional many-to-one association to Milestone
	@ManyToOne
	@JoinColumn(name="MILESTONE_PARENT")
	private Milestone milestone;

	//bi-directional many-to-one association to Milestone
	@OneToMany(mappedBy="milestone")
	private List<Milestone> milestones;

	//bi-directional many-to-one association to MilestoneTeam
	@OneToMany(mappedBy="milestone")
	private List<MilestoneTeam> milestonesTeams;

	//bi-directional many-to-one association to Note
	@OneToMany(mappedBy="milestone")
	private List<Note> notes;

	public Milestone() {
	}

	public long getMilestoneId() {
		return this.milestoneId;
	}

	public void setMilestoneId(long milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAsumptions() {
		return this.asumptions;
	}

	public void setAsumptions(String asumptions) {
		this.asumptions = asumptions;
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
		file.setMilestone(this);

		return file;
	}

	public File removeFile(File file) {
		getFiles().remove(file);
		file.setMilestone(null);

		return file;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Initiative getInitiative() {
		return this.initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

	public Milestone getMilestone() {
		return this.milestone;
	}

	public void setMilestone(Milestone milestone) {
		this.milestone = milestone;
	}

	public List<Milestone> getMilestones() {
		return this.milestones;
	}

	public void setMilestones(List<Milestone> milestones) {
		this.milestones = milestones;
	}

	public Milestone addMilestone(Milestone milestone) {
		getMilestones().add(milestone);
		milestone.setMilestone(this);

		return milestone;
	}

	public Milestone removeMilestone(Milestone milestone) {
		getMilestones().remove(milestone);
		milestone.setMilestone(null);

		return milestone;
	}

	public List<MilestoneTeam> getMilestonesTeams() {
		return this.milestonesTeams;
	}

	public void setMilestonesTeams(List<MilestoneTeam> milestonesTeams) {
		this.milestonesTeams = milestonesTeams;
	}

	public MilestoneTeam addMilestonesTeam(MilestoneTeam milestonesTeam) {
		getMilestonesTeams().add(milestonesTeam);
		milestonesTeam.setMilestone(this);

		return milestonesTeam;
	}

	public MilestoneTeam removeMilestonesTeam(MilestoneTeam milestonesTeam) {
		getMilestonesTeams().remove(milestonesTeam);
		milestonesTeam.setMilestone(null);

		return milestonesTeam;
	}

	public List<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Note addNote(Note note) {
		getNotes().add(note);
		note.setMilestone(this);

		return note;
	}

	public Note removeNote(Note note) {
		getNotes().remove(note);
		note.setMilestone(null);

		return note;
	}

}