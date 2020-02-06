/*
 * AsistenteController.java
 *
 * Created on 28 de junio de 2007, 14:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package controladores;

import comandos.ComandoPersona;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;
import utilidades.DemoCorreoImpl;

/**
 *
 * @author Administrador
 */
public class AsistenteController extends AbstractWizardFormController{
    private DemoCorreoImpl demoCorreo;

    public void setDemoCorreo(DemoCorreoImpl demoCorreo) {
        this.demoCorreo = demoCorreo;
    }
    /** Creates a new instance of AsistenteController */
    public AsistenteController() {
        setCommandName("comandoPersona");
        setCommandClass(ComandoPersona.class);
        setPages(new String[] {"primera","segunda","tercera"});
    }
    
    protected ModelAndView processFinish(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, BindException bindException) throws Exception {        
        demoCorreo.enviarMensaje((ComandoPersona)object);
        ModelAndView mav = new ModelAndView("cuarta");
        mav.addObject("persona",object);
        return mav;
    }

    @Override
    protected int getTargetPage(HttpServletRequest request, Object command, Errors errors, int currentPage) {
        switch(currentPage){
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            default:
                return 3;
        }
    }

    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView("quinta");
    }
    
}
