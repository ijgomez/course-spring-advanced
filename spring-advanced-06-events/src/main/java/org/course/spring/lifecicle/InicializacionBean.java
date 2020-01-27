package org.course.spring.lifecicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InicializacionBean implements InitializingBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeDondeVengoBean.class);

    private String name;

    
    public void afterPropertiesSet() throws Exception {
        if (this.name == null) {
            LOGGER.info("La propiedad nombre de este bean no se ha inicializado");
        }
    }
}
