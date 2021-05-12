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

import com.divergent.springboot.entity.Labtest;
import com.divergent.springboot.service.LabtestService;

@Controller
@RequestMapping("/labtest")
public class LabtestController {

	@Autowired
	private LabtestService labtestService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Labtest> allTests = labtestService.list();
		ModelAndView model = new ModelAndView("labtest");
		model.addObject("allTests", allTests);

		return model;

	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String testName = req.getParameter("name");
		int testPrice = Integer.parseInt(req.getParameter("price"));
		labtestService.add(testName, testPrice);
		return "redirect:/labtest";

	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int testId = Integer.parseInt(req.getParameter("testId"));
		labtestService.remove(testId);
		return "redirect:/labtest";

	}

}
