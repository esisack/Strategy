package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the FREQUENCIES database table.
 * 
 */
@Entity
@Table(name="FREQUENCIES")
@NamedQuery(name="Frequency.findAll", query="SELECT f FROM Frequency f")
public class Frequency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FREQUENCIES_FREQUENCYID_GENERATOR", sequenceName="FREQUENCY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FREQUENCIES_FREQUENCYID_GENERATOR")
	@Column(name="FREQUENCY_ID")
	private String frequencyId;

	@Column(name="FREQUENCY_CODE")
	private String frequencyCode;

	@Column(name="FREQUENCY_NAME")
	private String frequencyName;

	private String status;

	//bi-directional many-to-one association to Initiative
	@OneToMany(mappedBy="frequency")
	private List<Initiative> initiatives;

	//bi-directional many-to-one association to Measure
	@OneToMany(mappedBy="frequency")
	private List<Measure> measures;

	//bi-directional many-to-one association to Objective
	@OneToMany(mappedBy="frequency")
	private List<Objective> objectives;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="frequency")
	private List<Scorecard> scorecards;

	public Frequency() {
	}

	public String getFrequencyId() {
		return this.frequencyId;
	}

	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getFrequencyCode() {
		return this.frequencyCode;
	}

	public void setFrequencyCode(String frequencyCode) {
		this.frequencyCode = frequencyCode;
	}

	public String getFrequencyName() {
		return this.frequencyName;
	}

	public void setFrequencyName(String frequencyName) {
		this.frequencyName = frequencyName;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Initiative> getInitiatives() {
		return this.initiatives;
	}

	public void setInitiatives(List<Initiative> initiatives) {
		this.initiatives = initiatives;
	}

	public Initiative addInitiative(Initiative initiative) {
		getInitiatives().add(initiative);
		initiative.setFrequency(this);

		return initiative;
	}

	public Initiative removeInitiative(Initiative initiative) {
		getInitiatives().remove(initiative);
		initiative.setFrequency(null);

		return initiative;
	}

	public List<Measure> getMeasures() {
		return this.measures;
	}

	public void setMeasures(List<Measure> measures) {
		this.measures = measures;
	}

	public Measure addMeasure(Measure measure) {
		getMeasures().add(measure);
		measure.setFrequency(this);

		return measure;
	}

	public Measure removeMeasure(Measure measure) {
		getMeasures().remove(measure);
		measure.setFrequency(null);

		return measure;
	}

	public List<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public Objective addObjective(Objective objective) {
		getObjectives().add(objective);
		objective.setFrequency(this);

		return objective;
	}

	public Objective removeObjective(Objective objective) {
		getObjectives().remove(objective);
		objective.setFrequency(null);

		return objective;
	}

	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setFrequency(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setFrequency(null);

		return scorecard;
	}

}