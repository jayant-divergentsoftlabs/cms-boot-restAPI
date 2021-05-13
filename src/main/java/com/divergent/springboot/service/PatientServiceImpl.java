package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.PatientDao;
import com.divergent.springboot.dao.PatientRepository;
import com.divergent.springboot.entity.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDao patientDao;

	@Autowired
	PatientRepository patientRepository;
	
	@Transactional
	@Override
	public Patient add(Patient patient) {
		
		//return patientDao.add(patient);
       return patientRepository.save(patient);
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

	@Override
	public void update(Patient patient) {
		
		
	}

}
