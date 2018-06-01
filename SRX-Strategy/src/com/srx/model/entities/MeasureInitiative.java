package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MEASURES_INITIATIVES database table.
 * 
 */
@Entity
@Table(name="MEASURES_INITIATIVES")
@NamedQuery(name="MeasureInitiative.findAll", query="SELECT m FROM MeasureInitiative m")
public class MeasureInitiative implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEASURES_INITIATIVES_MEASUREINITIATIVEID_GENERATOR", sequenceName="MEASURE_INITIATIVE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEASURES_INITIATIVES_MEASUREINITIATIVEID_GENERATOR")
	@Column(name="MEASURE_INITIATIVE_ID")
	private long measureInitiativeId;

	//bi-directional many-to-one association to Initiative
	@ManyToOne
	@JoinColumn(name="INITIATIVE_ID")
	private Initiative initiative;

	//bi-directional many-to-one association to Measure
	@ManyToOne
	@JoinColumn(name="MEASURE_ID")
	private Measure measure;

	public MeasureInitiative() {
	}

	public long getMeasureInitiativeId() {
		return this.measureInitiativeId;
	}

	public void setMeasureInitiativeId(long measureInitiativeId) {
		this.measureInitiativeId = measureInitiativeId;
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

}