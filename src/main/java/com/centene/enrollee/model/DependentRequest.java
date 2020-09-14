package com.centene.enrollee.model;

import java.time.LocalDate;

public class DependentRequest {

	private String dependentName;
	private LocalDate dependentDOB;
	private long enrolleeId;

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

	public long getEnrolleeId() {
		return enrolleeId;
	}

	public void setEnrolleeId(long enrolleeId) {
		this.enrolleeId = enrolleeId;
	}

}
