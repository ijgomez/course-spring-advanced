/*
 * PrimerControlador.java
 *
 * Created on 10 de junio de 2007, 21:08
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.course.spring.controllers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author user
 */
public class PrimerControlador implements Controller{
    
    /** Creates a new instance of PrimerControlador */
    public PrimerControlador() {
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("primera");
        mav.addObject("fecha", new Date());
        return mav;
    }
    
}
