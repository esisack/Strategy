package com.srx.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the JOBS database table.
 * 
 */
@Entity
@Table(name="JOBS")
@NamedQuery(name="Job.findAll", query="SELECT j FROM Job j")
public class Job implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="JOBS_JOBID_GENERATOR", sequenceName="JOB_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="JOBS_JOBID_GENERATOR")
	@Column(name="JOB_ID")
	private long jobId;

	@Column(name="JOB_AREA")
	private String jobArea;

	@Column(name="JOB_DESCRIPTION")
	private String jobDescription;

	@Column(name="JOB_NAME")
	private String jobName;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="job")
	private List<Employee> employees;

	//bi-directional many-to-one association to Job
	@ManyToOne
	@JoinColumn(name="PARENT_JOB")
	private Job job;

	//bi-directional many-to-one association to Job
	@OneToMany(mappedBy="job")
	private List<Job> jobs;

	public Job() {
	}

	public long getJobId() {
		return this.jobId;
	}

	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	public String getJobArea() {
		return this.jobArea;
	}

	public void setJobArea(String jobArea) {
		this.jobArea = jobArea;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setJob(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setJob(null);

		return employee;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public Job addJob(Job job) {
		getJobs().add(job);
		job.setJob(this);

		return job;
	}

	public Job removeJob(Job job) {
		getJobs().remove(job);
		job.setJob(null);

		return job;
	}

}