package com.centene.enrollee.model;

import java.time.LocalDate;
import java.util.List;

import com.centene.enrollee.entity.Dependent;
import com.fasterxml.jackson.annotation.JsonFormat;

public class EnrolleeRequest {

	private String enrolleeName;

	private String phoneNumber;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrolleeDOB;

	private boolean status;

	private List<Dependent> dependents;

	public String getEnrolleeName() {
		return enrolleeName;
	}

	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getEnrolleeDOB() {
		return enrolleeDOB;
	}

	public void setEnrolleeDOB(LocalDate enrolleeDOB) {
		this.enrolleeDOB = enrolleeDOB;
	}

	public List<Dependent> getDependents() {
		return dependents;
	}

	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}

}
