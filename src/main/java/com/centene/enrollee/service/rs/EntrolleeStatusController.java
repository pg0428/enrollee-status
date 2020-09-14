package com.centene.enrollee.service.rs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.centene.enrollee.entity.Dependent;
import com.centene.enrollee.entity.Enrollee;
import com.centene.enrollee.model.DependentRequest;
import com.centene.enrollee.model.EnrolleeRequest;
import com.centene.enrollee.service.DependentService;
import com.centene.enrollee.service.EnrolleeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EntrolleeStatusController {

	@Autowired
	EnrolleeService enrolleeService;

	@Autowired
	DependentService dependentService;

	Logger logger = LoggerFactory.getLogger(EntrolleeStatusController.class);

	@ApiOperation(value = "Get All Enrolled Users Info", notes = "Get Enrollees and their dependents info")
	@GetMapping(value = { "/enrollee-status/enrollees" })
	public List<Enrollee> getEnrolledsList() {
		logger.info("Get all enrollees Info");
		return enrolleeService.getEnrollees();
	}

	@ApiOperation(value = "Add Enrollee Record", notes = "Add New Enrollee Record")
	@PostMapping(value = { "/enrollee-status/enrollee" })
	@ResponseStatus(HttpStatus.CREATED)
	public Enrollee addEnrollee(@RequestBody EnrolleeRequest enrolleeRequest) {
		logger.info("Creating new enrollee with {} {} {} ", enrolleeRequest.getEnrolleeName(),
				enrolleeRequest.getPhoneNumber(), enrolleeRequest.getEnrolleeDOB());
		return enrolleeService.addEnrollee(enrolleeRequest);
	}

	@PutMapping(value = "/enrollee-status/{enrolleeId}")
	public Enrollee updateEnrollee(@PathVariable long enrolleeId, @RequestBody EnrolleeRequest enrolleeRequest) {
		logger.info("Updating enrollee record");
		return enrolleeService.updateEnrolleeById(enrolleeId, enrolleeRequest);
	}

	@DeleteMapping(value = "/enrollee-status/{enrolleeId}")
	public ResponseEntity<Enrollee> deleteEnrolleeById(@PathVariable long enrolleeId) {
		logger.info("Deleting enrollee and dependents info for enrollee: {}", enrolleeId);
		return enrolleeService.deleteEnrolleeById(enrolleeId);
	}

	@GetMapping(value = "/enrollee-status/dependents")
	public List<Dependent> getDependentsList() {
		logger.info("Get all dependents and enrollees Info");
		return dependentService.getAllDependents();
	}

	@PostMapping(value = "/enrollee-status/dependent")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Dependent> addDependents(@RequestBody List<DependentRequest> dependent) {
		return dependentService.addDependents(dependent);
	}

	@DeleteMapping(value = "/enrollee-status/dependent/{enrolleeId}")
	public void deleteAllDependentsOnEnrollee(@PathVariable long enrolleeId) {
		dependentService.deleteAllDependentsOnEnrollee(enrolleeId);
	}

	@PutMapping(value = "/enrollee-status/dependent/{dependentId}")
	public Dependent updateDependent(@PathVariable long dependentId, @RequestBody DependentRequest dependent) {
		return dependentService.updateDependentById(dependentId, dependent);
	}

}
