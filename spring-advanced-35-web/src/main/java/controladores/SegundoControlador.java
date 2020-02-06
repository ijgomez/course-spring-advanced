/*
 * SegundoControlador.java
 *
 * Created on 10 de junio de 2007, 21:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author user
 */
public class SegundoControlador implements Controller{
    
    /** Creates a new instance of SegundoControlador */
    public SegundoControlador() {
    }
    
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("segunda");
    }
    
}
