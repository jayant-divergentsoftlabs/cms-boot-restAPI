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

import com.divergent.springboot.entity.Drug;
import com.divergent.springboot.service.DrugService;

@Controller
@RequestMapping("/drug")
public class DrugController {
	@Autowired
	private DrugService drugService;

	@GetMapping
	protected ModelAndView showPage() {
		List<Drug> allDrugs = drugService.list();
		ModelAndView model = new ModelAndView("drug");
		model.addObject("allDrugs", allDrugs);

		return model;

	}

	@PostMapping
	protected String save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String drugName = req.getParameter("name");
		int drugPrice = Integer.parseInt(req.getParameter("price"));
		drugService.add(drugName, drugPrice);
		return "redirect:/drug";

	}

	@GetMapping("/remove")
	protected String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int drugId = Integer.parseInt(req.getParameter("drugId"));
		drugService.remove(drugId);
		return "redirect:/drug";

	}

}
