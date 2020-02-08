package org.course.spring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.course.spring.beans.Login;
import org.course.spring.services.LoginService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginFormController extends SimpleFormController {

	private LoginService loginService;

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Login comando = (Login) command;
		log.info("El tipo de comando es: " + comando.getClass().getName());
		ModelAndView mav = new ModelAndView(getSuccessView());
		if (this.loginService.autenticacionOk(comando)) {
			mav.addObject("nombre", comando.getNombre());
			mav.addObject("clave", comando.getClave());
		} else {
			mav.addObject("errorLogin", "La combinación de usuario y clave no se encuentra.");
			mav.addObject("sugerencia", "Por favor, intántelo de nuevo.");
		}
		return mav;
	}

	public LoginService getLoginService() {
		return loginService;
	}
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
