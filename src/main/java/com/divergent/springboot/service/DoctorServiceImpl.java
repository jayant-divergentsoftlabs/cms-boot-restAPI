package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.DoctorDao;
import com.divergent.springboot.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	@Transactional
	@Override
	public void add(String name, String speciality, int fee) {
		Doctor doctor = new Doctor();
		doctor.setName(name);
		doctor.setSpeciality(speciality);
		doctor.setFee(fee);
		doctorDao.add(doctor);
	}

	@Transactional
	@Override
	public boolean remove(int id) {
		Doctor doctor = this.findById(id);
		if (doctor != null) {
			this.doctorDao.remove(doctor);
			return true;
		}
		return false;

	}

	@Transactional
	@Override
	public Doctor findById(int id) {
		return doctorDao.findById(id);
	}

	@Transactional
	@Override
	public List<Doctor> listAll() {
		return this.doctorDao.listAll();
	}

	@Override
	public Doctor update(Doctor doctor) {
		doctorDao.add(doctor);
		return doctor;
	}

}
