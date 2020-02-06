/*
 * TercerInterceptor.java
 *
 * Created on 23 de junio de 2007, 13:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author user
 */
public class TercerInterceptor implements HandlerInterceptor{
    Log log = LogFactory.getLog(getClass());
    
    /** Creates a new instance of TercerInterceptor */
    public TercerInterceptor() {
    }
    
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        log.info("Ejecución del tercer interceptor, método preHandle. Handler: " + object.getClass().getName());
        log.info("URI:" + httpServletRequest.getRequestURI());
        if (httpServletRequest.getRequestURI().endsWith("cuarta.curso")) {
            httpServletResponse.sendRedirect("quinta.curso");
            return false;
        } else {
            return true;
        }
        
    }
    
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
        log.info("Ejecución del tercer interceptor, método postHandle. Handler: " + object.getClass().getName());
        
    }
    
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) throws Exception {
        log.info("Ejecución del tercer interceptor, método afterCompletion. Handler: " + object.getClass().getName());
        
    }
    
}
