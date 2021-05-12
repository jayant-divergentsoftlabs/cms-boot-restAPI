package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Doctor;

public interface DoctorDao {
	void add(Doctor doctor);

	List<Doctor> listAll();

	void remove(Doctor doctor);

	Doctor findById(int id);

	void update(Doctor doctor);

}
