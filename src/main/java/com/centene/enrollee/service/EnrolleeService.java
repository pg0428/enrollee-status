package com.centene.enrollee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.centene.enrollee.dao.EnrolleeRepo;
import com.centene.enrollee.entity.Dependent;
import com.centene.enrollee.entity.Enrollee;
import com.centene.enrollee.model.EnrolleeRequest;

@Service
public class EnrolleeService {

	@Autowired
	EnrolleeRepo enrolleeRepo;

	public List<Enrollee> getEnrollees() {
		return enrolleeRepo.findAll();
	}

	public Optional<Enrollee> getEnrolleeById(Long enrolleeId) {
		return enrolleeRepo.findById(enrolleeId);
	}

	public Enrollee addEnrollee(EnrolleeRequest requestParams) {
		Enrollee enrollee = new Enrollee();
		enrollee.setEnrolleeName(requestParams.getEnrolleeName());
		enrollee.setEnrolleeStatus(requestParams.isStatus());
		enrollee.setEnrolleePhoneNumber(requestParams.getPhoneNumber());
		enrollee.setEnrolleeDOB(requestParams.getEnrolleeDOB());
		if (requestParams.getDependents() != null) {
			for (Dependent dep : requestParams.getDependents()) {
				enrollee.getDependents().add(new Dependent(dep.getDependentName(), dep.getDependentDOB(), enrollee));
			}
		}
		return enrolleeRepo.save(enrollee);
	}

	public Enrollee updateEnrolleeById(Long enrolleeId, EnrolleeRequest requestParams) {
		Optional<Enrollee> enrollee = enrolleeRepo.findById(enrolleeId);
		Enrollee enr = null;
		if (enrollee.isPresent()) {
			enr = enrollee.get();
			enr.setEnrolleeName(requestParams.getEnrolleeName());
			enr.setEnrolleeStatus(requestParams.isStatus());
			enr.setEnrolleePhoneNumber(requestParams.getPhoneNumber());
			enr.setEnrolleeDOB(requestParams.getEnrolleeDOB());
			return enrolleeRepo.save(enr);
		}
		return new Enrollee();
	}

	public ResponseEntity<Enrollee> deleteEnrolleeById(long enrolleeId) {
		enrolleeRepo.deleteById(enrolleeId);
		return ResponseEntity.ok().build();
	}

}
