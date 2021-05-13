package com.divergent.springboot.service;

import java.util.List;

import com.divergent.springboot.entity.Appointment;

public interface AppointmentService {

	public List<Appointment> getList();

	public Appointment add(Appointment appointment);

}
