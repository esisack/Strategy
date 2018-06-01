package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PERSPECTIVES database table.
 * 
 */
@Entity
@Table(name="PERSPECTIVES")
@NamedQuery(name="Perspective.findAll", query="SELECT p FROM Perspective p")
public class Perspective implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PERSPECTIVES_PERSPECTIVEID_GENERATOR", sequenceName="PERSPECTIVE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERSPECTIVES_PERSPECTIVEID_GENERATOR")
	@Column(name="PERSPECTIVE_ID")
	private long perspectiveId;

	private String description;

	@Column(name="PERSPECTIVE_NAME")
	private String perspectiveName;

	//bi-directional many-to-one association to Objective
	@OneToMany(mappedBy="perspective")
	private List<Objective> objectives;

	public Perspective() {
	}

	public long getPerspectiveId() {
		return this.perspectiveId;
	}

	public void setPerspectiveId(long perspectiveId) {
		this.perspectiveId = perspectiveId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPerspectiveName() {
		return this.perspectiveName;
	}

	public void setPerspectiveName(String perspectiveName) {
		this.perspectiveName = perspectiveName;
	}

	public List<Objective> getObjectives() {
		return this.objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}

	public Objective addObjective(Objective objective) {
		getObjectives().add(objective);
		objective.setPerspective(this);

		return objective;
	}

	public Objective removeObjective(Objective objective) {
		getObjectives().remove(objective);
		objective.setPerspective(null);

		return objective;
	}

}