package com.divergent.springboot.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergent.springboot.entity.Appointment;
import com.divergent.springboot.entity.Doctor;
import com.divergent.springboot.service.AppointmentService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AppointmentService appointmentService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Appointment> allAppointments = appointmentService.getList();
		ModelAndView model = new ModelAndView("appointment");
		model.addObject("allAppointments", allAppointments);
		return model;

	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String problem = req.getParameter("problem");
		int appointmentId = Integer.parseInt(req.getParameter("id"));
		LocalDate date = LocalDate.parse(req.getParameter("date"));
		int doctorId = Integer.parseInt(req.getParameter("doctor"));
		int patientId = Integer.parseInt(req.getParameter("patient"));

		Doctor doctor = new Doctor();
		appointmentService.add(appointmentId, problem, patientId, doctorId);
		return "redirect:/appointment";

	}



}