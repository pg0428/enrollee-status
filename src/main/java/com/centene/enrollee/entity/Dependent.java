package com.centene.enrollee.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity(name = "dependent")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Dependent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dependent_id")
	private long dependentId;

	@Column(name = "dependent_name")
	private String dependentName;

	@Column(name = "dependent_dob")
	private LocalDate dependentDOB;

	@ManyToOne
	@JoinColumn(name = "enrollee_id", nullable = false, updatable = false)
	@JsonIgnoreProperties("dependents")
	private Enrollee enrollee;

	public Dependent() {
		// default
	}

	public Dependent(String dependentName, LocalDate dependentDOB, Enrollee enrollee) {
		this.dependentName = dependentName;
		this.dependentDOB = dependentDOB;
		this.enrollee = enrollee;
	}

	public long getDependentId() {
		return dependentId;
	}

	public void setDependentId(long dependentId) {
		this.dependentId = dependentId;
	}

	public String getDependentName() {
		return dependentName;
	}

	public void setDependentName(String dependentName) {
		this.dependentName = dependentName;
	}

	public LocalDate getDependentDOB() {
		return dependentDOB;
	}

	public void setDependentDOB(LocalDate dependentDOB) {
		this.dependentDOB = dependentDOB;
	}

	public Enrollee getEnrollee() {
		return enrollee;
	}

	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}
}
