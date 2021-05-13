package com.divergent.springboot.controller;

import java.io.IOException;
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

import com.divergent.springboot.entity.Doctor;
import com.divergent.springboot.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DoctorService doctorService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Doctor> allDoctors = doctorService.listAll();
		ModelAndView model = new ModelAndView("doctor");
		model.addObject("allDoctors", allDoctors);

		return model;

	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String doctorName = req.getParameter("name");
		String doctorSpeciality = req.getParameter("speciality");
		int doctorFee = Integer.parseInt(req.getParameter("fee"));

		Doctor doctor = new Doctor();
		doctorService.add(doctor);
		return "redirect:/doctor";

	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		doctorService.remove(doctorId);
		return "redirect:/doctor";

	}

	@GetMapping("/search")
	protected Doctor search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int doctorId = Integer.parseInt(req.getParameter("doctorId"));
		return this.doctorService.findById(doctorId);

	}

	@GetMapping("/update")
	protected Doctor findById(Doctor doctor) {
		return this.doctorService.update(doctor);
	}
}
