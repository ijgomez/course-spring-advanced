/*
 * SegundoInterceptor.java
 *
 * Created on 10 de junio de 2007, 22:47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author user
 */
public class SegundoInterceptor extends HandlerInterceptorAdapter{
    Log log = LogFactory.getLog(getClass());
    /** Creates a new instance of SegundoInterceptor */
    public SegundoInterceptor() {
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Ejecución del segundo interceptor, método preHandle. Handler: " + handler.getClass().getName());
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("Ejecución del segundo interceptor, método postHandle. Handler: " + handler.getClass().getName());
    }
    
}
