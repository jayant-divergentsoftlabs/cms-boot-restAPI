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

import com.divergent.springboot.entity.Doctor;
import com.divergent.springboot.service.DoctorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/doctor", produces = "application/json")
@CrossOrigin(origins = "*")
public class DoctorRestController {

		@Autowired
		private DoctorService doctorService;

		@GetMapping("/get")
		private ResponseEntity<List<Doctor>> getAll() {
			log.debug("get all doctors");
			List<Doctor> allDoctors = doctorService.listAll();

			return new ResponseEntity<>(allDoctors, HttpStatus.OK);
		}

		@DeleteMapping("/remove/{doctorId}")
		@ResponseStatus(HttpStatus.OK)
		private void delete(@PathVariable int doctorId) {
			doctorService.remove(doctorId);
		}

		@GetMapping("/get/{doctorId}")
		private ResponseEntity<Doctor> find(@PathVariable int doctorId) {
			Doctor doctor = doctorService.findById(doctorId);

			if (doctor != null) {
				return new ResponseEntity<>(doctor, HttpStatus.OK);
			}
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		@PutMapping("/update")
		@ResponseStatus(HttpStatus.OK)
		private void update(@RequestBody Doctor doctor) {
			doctorService.update(doctor);
		}

		@PostMapping("/add")
		@ResponseStatus(HttpStatus.CREATED)
		private void insert(@RequestBody Doctor doctor) {
			doctorService.add(doctor);
		}
	}



