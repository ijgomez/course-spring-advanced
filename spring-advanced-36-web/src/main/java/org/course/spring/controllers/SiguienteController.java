package org.course.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class SiguienteController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("siguiente");
		mav.addObject("mensaje", "La clase de este controlador es " + getClass().getName());
		return mav;
	}
}
