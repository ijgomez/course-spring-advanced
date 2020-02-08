package org.course.spring.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TercerInterceptor implements HandlerInterceptor{
    
	@Override
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
    
	@Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, ModelAndView modelAndView) throws Exception {
        log.info("Ejecución del tercer interceptor, método postHandle. Handler: " + object.getClass().getName());
    }
    
	@Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object, Exception exception) throws Exception {
        log.info("Ejecución del tercer interceptor, método afterCompletion. Handler: " + object.getClass().getName());
    }
    
}
