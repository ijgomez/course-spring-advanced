/*
 * CuartoControlador.java
 *
 * Created on 10 de junio de 2007, 22:04
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
public class CuartoControlador implements Controller {
    
    /** Creates a new instance of CuartoControlador */
    public CuartoControlador() {
    }
    
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        return new ModelAndView("cuarta");
    }
    
}
