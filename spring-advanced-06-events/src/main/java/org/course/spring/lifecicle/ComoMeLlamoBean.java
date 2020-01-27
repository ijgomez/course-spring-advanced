package org.course.spring.lifecicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

public class ComoMeLlamoBean implements BeanNameAware {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComoMeLlamoBean.class);
	
    public void setBeanName(String idBean) {
        LOGGER.info("El identificador de este bean es {}", idBean);
    }
}
