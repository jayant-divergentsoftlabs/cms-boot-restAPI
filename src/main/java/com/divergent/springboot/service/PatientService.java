package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Patient;

public interface PatientService {
	public void add(String name, int age, String gender, int weight,long contactNo, String address);

	public boolean remove(int id);

	public Patient findById(int id);
	
	public List<Patient> listAll();
}
