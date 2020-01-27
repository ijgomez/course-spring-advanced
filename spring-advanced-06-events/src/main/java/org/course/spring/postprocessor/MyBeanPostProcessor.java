package org.course.spring.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyBeanPostProcessor.class);
	
	@Override
    public Object postProcessBeforeInitialization(Object object, String string) throws BeansException {
        LOGGER.info("En postProcessBeforeInitialization.Bean {}. Se llama {}", object, string);        
        return object;
    }

	@Override
    public Object postProcessAfterInitialization(Object object, String string) throws BeansException {
		LOGGER.info("En postProcessAfterInitialization.Bean {}. Se llama {}", object, string);        
        return object;
    }
    
}
