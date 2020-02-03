package org.course.spring.aspects;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

@Aspect
public class Recovery {

	private static final Logger log = LoggerFactory.getLogger(Recovery.class);
	
    @AfterThrowing(pointcut = "execution(* *..PersonService.read(..))", throwing = "ex")
    public void realizarRecuperacion(DataAccessException ex) {
        log.info("Ha ocurrido un error al acceder a datos:" + ex.getMessage());
    }
}
