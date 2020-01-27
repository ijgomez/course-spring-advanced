package org.course.spring.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyApplicationContextAware implements ApplicationContextAware {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyApplicationContextAware.class);
    
	private ApplicationContext ctx;
   
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
        LOGGER.info("Contexto recibido");
    }
    
    public void generarEvento(){
        ctx.publishEvent(new MyApplicationEvent(this));
    }
}
