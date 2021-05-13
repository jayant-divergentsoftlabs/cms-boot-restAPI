package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Appointment;



public interface AppointmentDao {

public Appointment add(Appointment appointment);
	
	public List<Appointment> get();
	
}


