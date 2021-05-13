package com.divergent.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.divergent.springboot.dao.AppointmentDao;
import com.divergent.springboot.entity.Appointment;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private AppointmentDao appointmentDao;

	@Transactional
	@Override
	public Appointment add(Appointment appointment) {

		return appointmentDao.add(appointment);
	}

	@Override
	public List<Appointment> getList() {
		return appointmentDao.get();
	}

}
