package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Appointment;


public interface AppointmentService {
	
public void add(int appointmentId, String problem, int patientId, int doctorId);
	
	public List<Appointment> getList();

	

}
