package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Patient;

public interface PatientService {

	public boolean remove(int id);

	public Patient findById(int id);
	
	public List<Patient> listAll();

	public void update(Patient patient);

	public Patient add(Patient patient);
}
