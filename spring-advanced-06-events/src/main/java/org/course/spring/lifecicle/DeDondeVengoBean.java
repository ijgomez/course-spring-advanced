package org.course.spring.lifecicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class DeDondeVengoBean implements BeanFactoryAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeDondeVengoBean.class);
	
    private BeanFactory beanFactory;

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        
        LOGGER.info("Método llamado por Spring al inyectar la factoría {} a este objeto.", this.beanFactory.getClass().getSimpleName());
    }
}
