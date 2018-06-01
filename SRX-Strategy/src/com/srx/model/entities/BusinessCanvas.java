package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BUSINESS_CANVAS database table.
 * 
 */
@Entity
@Table(name="BUSINESS_CANVAS")
@NamedQuery(name="BusinessCanvas.findAll", query="SELECT b FROM BusinessCanvas b")
public class BusinessCanvas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESS_CANVAS_BUSINESSCANVASID_GENERATOR", sequenceName="BUSINESS_CANVAS_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESS_CANVAS_BUSINESSCANVASID_GENERATOR")
	@Column(name="BUSINESS_CANVAS_ID")
	private long businessCanvasId;

	private String channels;

	@Column(name="CUSTOMERS_RELATIONSHIP")
	private String customersRelationship;

	@Column(name="CUSTOMERS_SEGMENTS")
	private String customersSegments;

	@Column(name="KEY_ACTIVITIES")
	private String keyActivities;

	@Column(name="KEY_PARTNERSHIP")
	private String keyPartnership;

	@Column(name="KEY_RESOURCES")
	private String keyResources;

	@Column(name="VALUE_PROPOSITIONS")
	private String valuePropositions;

	//bi-directional many-to-one association to BusinessPlan
	@ManyToOne
	@JoinColumn(name="BUSINESS_PLAN_ID")
	private BusinessPlan businessPlan;

	public BusinessCanvas() {
	}

	public long getBusinessCanvasId() {
		return this.businessCanvasId;
	}

	public void setBusinessCanvasId(long businessCanvasId) {
		this.businessCanvasId = businessCanvasId;
	}

	public String getChannels() {
		return this.channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getCustomersRelationship() {
		return this.customersRelationship;
	}

	public void setCustomersRelationship(String customersRelationship) {
		this.customersRelationship = customersRelationship;
	}

	public String getCustomersSegments() {
		return this.customersSegments;
	}

	public void setCustomersSegments(String customersSegments) {
		this.customersSegments = customersSegments;
	}

	public String getKeyActivities() {
		return this.keyActivities;
	}

	public void setKeyActivities(String keyActivities) {
		this.keyActivities = keyActivities;
	}

	public String getKeyPartnership() {
		return this.keyPartnership;
	}

	public void setKeyPartnership(String keyPartnership) {
		this.keyPartnership = keyPartnership;
	}

	public String getKeyResources() {
		return this.keyResources;
	}

	public void setKeyResources(String keyResources) {
		this.keyResources = keyResources;
	}

	public String getValuePropositions() {
		return this.valuePropositions;
	}

	public void setValuePropositions(String valuePropositions) {
		this.valuePropositions = valuePropositions;
	}

	public BusinessPlan getBusinessPlan() {
		return this.businessPlan;
	}

	public void setBusinessPlan(BusinessPlan businessPlan) {
		this.businessPlan = businessPlan;
	}

}