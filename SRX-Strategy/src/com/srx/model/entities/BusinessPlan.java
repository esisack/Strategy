package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BUSINESS_PLANS database table.
 * 
 */
@Entity
@Table(name="BUSINESS_PLANS")
@NamedQuery(name="BusinessPlan.findAll", query="SELECT b FROM BusinessPlan b")
public class BusinessPlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BUSINESS_PLANS_BUSINESSPLANID_GENERATOR", sequenceName="BUSINESS_PLAN_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BUSINESS_PLANS_BUSINESSPLANID_GENERATOR")
	@Column(name="BUSINESS_PLAN_ID")
	private long businessPlanId;

	private String analysis;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	private String status;

	private String title;

	//bi-directional many-to-one association to BusinessCanvas
	@OneToMany(mappedBy="businessPlan")
	private List<BusinessCanvas> businessCanvas;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="COMPANY_ID")
	private Company company;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="EMPLOYEE_ID")
	private Employee employee;

	public BusinessPlan() {
	}

	public long getBusinessPlanId() {
		return this.businessPlanId;
	}

	public void setBusinessPlanId(long businessPlanId) {
		this.businessPlanId = businessPlanId;
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public List<BusinessCanvas> getBusinessCanvas() {
		return this.businessCanvas;
	}

	public void setBusinessCanvas(List<BusinessCanvas> businessCanvas) {
		this.businessCanvas = businessCanvas;
	}

	public BusinessCanvas addBusinessCanva(BusinessCanvas businessCanva) {
		getBusinessCanvas().add(businessCanva);
		businessCanva.setBusinessPlan(this);

		return businessCanva;
	}

	public BusinessCanvas removeBusinessCanva(BusinessCanvas businessCanva) {
		getBusinessCanvas().remove(businessCanva);
		businessCanva.setBusinessPlan(null);

		return businessCanva;
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

}