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

import com.divergent.springboot.entity.Drug;
import com.divergent.springboot.entity.Labtest;
import com.divergent.springboot.service.DrugService;
import com.divergent.springboot.service.LabtestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/test", produces = "application/json")
@CrossOrigin(origins = "*")
public class LabtestRestController {
	@Autowired
	private LabtestService labtestService;

	@GetMapping("/get")
	private ResponseEntity<List<Labtest>> getAll() {
		log.debug("get Labtest");
		List<Labtest> allLabtests = labtestService.list();

		return new ResponseEntity<>(allLabtests, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{labtestId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int labtestId) {
		labtestService.remove(labtestId);
	}

	@GetMapping("/get/{labtestId}")
	private ResponseEntity<Labtest> find(@PathVariable int labtestId) {
		Labtest labtest= labtestService.findById(labtestId);

		if (labtest != null) {
			return new ResponseEntity<>(labtest, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Labtest labtest) {
		labtestService.update(labtest);
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	private void add(@RequestBody Labtest labtest) {
		labtestService.add(labtest);
	}

	
	
}
