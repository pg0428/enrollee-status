package com.centene.enrollee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centene.enrollee.dao.DependentRepo;
import com.centene.enrollee.dao.EnrolleeRepo;
import com.centene.enrollee.entity.Dependent;
import com.centene.enrollee.entity.Enrollee;
import com.centene.enrollee.model.DependentRequest;

@Service
public class DependentService {

	@Autowired
	DependentRepo dependentRepo;

	@Autowired
	EnrolleeRepo enrolleeRepo;

	public List<Dependent> getAllDependents() {
		return dependentRepo.findAll();
	}

	public Optional<Dependent> getDependentById(Long dependentId) {
		return dependentRepo.findById(dependentId);
	}

	public List<Dependent> addDependents(List<DependentRequest> dependentsList) {
		Optional<Enrollee> enrollee = enrolleeRepo.findById(dependentsList.get(0).getEnrolleeId());
		List<Dependent> dependents = new ArrayList<>();
		if (enrollee.isPresent()) {
			dependentsList.stream().map(dep -> {
				Dependent dependent = new Dependent(dep.getDependentName(), dep.getDependentDOB(), enrollee.get());
				dependentRepo.save(dependent);
				dependents.add(dependent);
				return dependent;
			}).collect(Collectors.toList());
		}
		return dependents;
	}

	public Dependent updateDependentById(Long dependentId, DependentRequest dependentReq) {
		Optional<Dependent> dep = dependentRepo.findById(dependentId);
		Dependent dependent = null;
		if (dep.isPresent()) {
			dependent = dep.get();
			dependent.setDependentDOB(dependentReq.getDependentDOB());
			dependent.setDependentName(dependentReq.getDependentName());
		}
		return dependentRepo.save(dependent);
	}

	public void deleteAllDependentsOnEnrollee(long enrolleeId) {
		Optional<Enrollee> enrollee = enrolleeRepo.findById(enrolleeId);
		if (enrollee.isPresent()) {
			enrollee.get().getDependents().clear();
			enrolleeRepo.save(enrollee.get());
			dependentRepo.deleteAll(enrollee.get().getDependents());
		}
	}
}
