package com.divergent.springboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.divergent.springboot.entity.Patient;
import com.divergent.springboot.service.PatientService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/patient", produces = "application/json")
@CrossOrigin(origins = "*")
public class PatientRestController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/get")
	private ResponseEntity<List<Patient>> getAll() {
		log.debug("get all patients");
		List<Patient> allPatients = patientService.listAll();

		return new ResponseEntity<>(allPatients, HttpStatus.OK);
	}

	@DeleteMapping("/{patientId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int patientId) {
		patientService.remove(patientId);
	}

	@GetMapping("/get/{patientId}")
	private ResponseEntity<Patient> find(@PathVariable int patientId) {
		Patient patient = patientService.findById(patientId);

		if (patient != null) {
			return new ResponseEntity<>(patient, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Patient patient) {
		patientService.update(patient);
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	private void insert(@RequestBody Patient patient) {
		patientService.add(patient);
	}

}
