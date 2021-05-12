package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.PatientDao;
import com.divergent.springboot.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Transactional
	@Override
	public void add(String name, int age, String gender, int weight, long contactNo, String address) {
		Patient patient = new Patient();
		patient.setName(name);
		patient.setAge(age);
		patient.setGender(gender);
		patient.setWeight(weight);
		patient.setContactNo(contactNo);
		patient.setAddress(address);
		patientDao.add(patient);

	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Patient patient = this.findById(id);
		if (patient != null) {
			this.patientDao.remove(patient);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Patient findById(int id) {
		return patientDao.findById(id);
	}

	@Transactional
	@Override
	public List<Patient> listAll() {
		return this.patientDao.listAll();
	}

}
