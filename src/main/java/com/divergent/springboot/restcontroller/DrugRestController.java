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
import com.divergent.springboot.service.DrugService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/drug", produces = "application/json")
@CrossOrigin(origins = "*")
public class DrugRestController {
	@Autowired
	private DrugService drugService;

	@GetMapping("/get")
	private ResponseEntity<List<Drug>> getAll() {
		log.debug("get all drugs");
		List<Drug> allDrugs = drugService.list();

		return new ResponseEntity<>(allDrugs, HttpStatus.OK);
	}

	@DeleteMapping("/remove/{drugId}")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@PathVariable int drugId) {
		drugService.remove(drugId);
	}

	@GetMapping("/get/{drugId}")
	private ResponseEntity<Drug> find(@PathVariable int drugId) {
		Drug drug = drugService.findById(drugId);

		if (drug != null) {
			return new ResponseEntity<>(drug, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	private void update(@RequestBody Drug drug) {
		drugService.update(drug);
	}

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	private void add(@RequestBody Drug drug) {
		drugService.add(drug);
	}

	

}
