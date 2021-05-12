package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Doctor;

public interface DoctorService {
	void add(String name, String speciality, int fee);

	boolean remove(int id);

	Doctor findById(int id);

	List<Doctor> listAll();

	public Doctor update(Doctor doctor);

}
