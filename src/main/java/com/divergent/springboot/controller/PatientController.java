package com.divergent.springboot.controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.divergent.springboot.entity.Patient;
import com.divergent.springboot.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private PatientService patientService;

	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	@GetMapping
	protected ModelAndView showPage() {
		List<Patient> allPatients = patientService.listAll();
		ModelAndView model = new ModelAndView("patient");
		model.addObject("allPatients", allPatients);

		return model;

	}

    @PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String patientName = req.getParameter("name");
		int patientAge = Integer.parseInt(req.getParameter("age"));
		String patientGender = req.getParameter("gender");
		int patientWeight = Integer.parseInt(req.getParameter("weight"));
		long patientContact = Long.parseLong(req.getParameter("contactno"));
		String patientAddress = req.getParameter("address");

		Patient patient = new Patient();
		patientService.add(patientName, patientAge,patientGender,patientWeight,patientContact,patientAddress);
		return "redirect:/patient";

	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int patientId = Integer.parseInt(req.getParameter("patientId"));
		patientService.remove(patientId);
		return "redirect:/patient";

	}

}
