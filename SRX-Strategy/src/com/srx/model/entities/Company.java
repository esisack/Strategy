package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COMPANIES database table.
 * 
 */
@Entity
@Table(name="COMPANIES")
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="COMPANIES_COMPANYID_GENERATOR", sequenceName="COMPANY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COMPANIES_COMPANYID_GENERATOR")
	@Column(name="COMPANY_ID")
	private long companyId;

	private String address;

	private String city;

	@Column(name="COMPANY_CODE")
	private String companyCode;

	@Column(name="COMPANY_NAME")
	private String companyName;

	private BigDecimal fax;

	private String mail;

	private BigDecimal phone;

	private String status;

	//bi-directional many-to-one association to Branch
	@OneToMany(mappedBy="company")
	private List<Branch> branches;

	//bi-directional many-to-one association to BusinessPlan
	@OneToMany(mappedBy="company")
	private List<BusinessPlan> businessPlans;

	//bi-directional many-to-one association to BusinessUnit
	@OneToMany(mappedBy="company")
	private List<BusinessUnit> businessUnits;

	//bi-directional many-to-one association to Division
	@OneToMany(mappedBy="company")
	private List<Division> divisions;

	//bi-directional many-to-one association to Scorecard
	@OneToMany(mappedBy="company")
	private List<Scorecard> scorecards;

	public Company() {
	}

	public long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompanyCode() {
		return this.companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getFax() {
		return this.fax;
	}

	public void setFax(BigDecimal fax) {
		this.fax = fax;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public BigDecimal getPhone() {
		return this.phone;
	}

	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Branch> getBranches() {
		return this.branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	public Branch addBranch(Branch branch) {
		getBranches().add(branch);
		branch.setCompany(this);

		return branch;
	}

	public Branch removeBranch(Branch branch) {
		getBranches().remove(branch);
		branch.setCompany(null);

		return branch;
	}

	public List<BusinessPlan> getBusinessPlans() {
		return this.businessPlans;
	}

	public void setBusinessPlans(List<BusinessPlan> businessPlans) {
		this.businessPlans = businessPlans;
	}

	public BusinessPlan addBusinessPlan(BusinessPlan businessPlan) {
		getBusinessPlans().add(businessPlan);
		businessPlan.setCompany(this);

		return businessPlan;
	}

	public BusinessPlan removeBusinessPlan(BusinessPlan businessPlan) {
		getBusinessPlans().remove(businessPlan);
		businessPlan.setCompany(null);

		return businessPlan;
	}

	public List<BusinessUnit> getBusinessUnits() {
		return this.businessUnits;
	}

	public void setBusinessUnits(List<BusinessUnit> businessUnits) {
		this.businessUnits = businessUnits;
	}

	public BusinessUnit addBusinessUnit(BusinessUnit businessUnit) {
		getBusinessUnits().add(businessUnit);
		businessUnit.setCompany(this);

		return businessUnit;
	}

	public BusinessUnit removeBusinessUnit(BusinessUnit businessUnit) {
		getBusinessUnits().remove(businessUnit);
		businessUnit.setCompany(null);

		return businessUnit;
	}

	public List<Division> getDivisions() {
		return this.divisions;
	}

	public void setDivisions(List<Division> divisions) {
		this.divisions = divisions;
	}

	public Division addDivision(Division division) {
		getDivisions().add(division);
		division.setCompany(this);

		return division;
	}

	public Division removeDivision(Division division) {
		getDivisions().remove(division);
		division.setCompany(null);

		return division;
	}

	public List<Scorecard> getScorecards() {
		return this.scorecards;
	}

	public void setScorecards(List<Scorecard> scorecards) {
		this.scorecards = scorecards;
	}

	public Scorecard addScorecard(Scorecard scorecard) {
		getScorecards().add(scorecard);
		scorecard.setCompany(this);

		return scorecard;
	}

	public Scorecard removeScorecard(Scorecard scorecard) {
		getScorecards().remove(scorecard);
		scorecard.setCompany(null);

		return scorecard;
	}

}