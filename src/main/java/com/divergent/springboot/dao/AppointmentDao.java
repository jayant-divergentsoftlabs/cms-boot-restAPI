package com.divergent.springboot.dao;

import java.util.List;

import com.divergent.springboot.entity.Appointment;



public interface AppointmentDao {

public void add(Appointment appointment);
	
	public List<Appointment> get();
	
}


