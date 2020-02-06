package springweb0005.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import springweb0005.beans.servicios.ServicioLogin;

public class LoginFormController extends SimpleFormController {
    private Log log = LogFactory.getLog(getClass());
    private ServicioLogin servicioLogin;

    public LoginFormController() {
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    Object command, 
                                    BindException errors) throws Exception {
        Login comando = (Login)command;
        log.info("El tipo de comando es: " + comando.getClass().getName());
        ModelAndView mav=new ModelAndView(getSuccessView());
        if(getServicioLogin().autenticacionOk(comando)){
            mav.addObject("nombre", comando.getNombre());
            mav.addObject("clave", comando.getClave());    
        }else{
            mav.addObject("errorLogin","La combinación de usuario y clave no se encuentra.");
            mav.addObject("sugerencia","Por favor, inténtelo de nuevo.");
        }        
        return mav;
    }

    protected ServicioLogin getServicioLogin() {
        return servicioLogin;
    }

    public void setServicioLogin(ServicioLogin servicioLogin) {
        this.servicioLogin = servicioLogin;
    }
}
