package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Patient;


public interface PatientDao {
	public Patient add(Patient patient);

	public void remove(Patient patient);

	Patient findById(int id);

	public List<Patient> listAll();
}
