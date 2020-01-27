package org.course.spring.lifecicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

public class DestruccionBean implements DisposableBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(DeDondeVengoBean.class);
	
    public void destroy() throws Exception {
        LOGGER.info("Destrucción de este bean");
    }
}
