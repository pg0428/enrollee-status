package com.centene.enrollee.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "enrollee")
public class Enrollee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "enrollee_id")
	private long enrolleeId;

	@Column(name = "enrollee_name")
	private String enrolleeName;

	@Column(name = "status")
	private boolean enrolleeStatus;

	@Column(name = "enrollee_dob")
	private LocalDate enrolleeDOB;

	@Column(name = "phone_number")
	private String enrolleePhoneNumber;

	@OneToMany(mappedBy = "enrollee", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("enrollee")
	private List<Dependent> dependents = new ArrayList<>();

	public Enrollee() {
		// default
	}

	public Enrollee(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

	public String getEnrolleeName() {
		return enrolleeName;
	}

	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public boolean isEnrolleeStatus() {
		return enrolleeStatus;
	}

	public void setEnrolleeStatus(boolean enrolleeStatus) {
		this.enrolleeStatus = enrolleeStatus;
	}

	public LocalDate getEnrolleeDOB() {
		return enrolleeDOB;
	}

	public void setEnrolleeDOB(LocalDate enrolleeDOB) {
		this.enrolleeDOB = enrolleeDOB;
	}

	public String getEnrolleePhoneNumber() {
		return enrolleePhoneNumber;
	}

	public void setEnrolleePhoneNumber(String enrolleePhoneNumber) {
		this.enrolleePhoneNumber = enrolleePhoneNumber;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

}
