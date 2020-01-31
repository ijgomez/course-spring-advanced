package org.course.spring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaludoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaludoService.class);

    public void principalAfter() {
        LOGGER.info("En " + getClass().getName() + " usando after");
    }

    public Long principalAfterReturning() {
        LOGGER.info("En " + getClass().getName() + " usando after returning");
        return System.currentTimeMillis();
    }

    public void metodoPublicoCualquiera() {
        LOGGER.info("En " + getClass().getName() + " usando after throwing");
        throw new IllegalArgumentException("Error de prueba");
    }

    public void principalBefore() {
        LOGGER.info("En " + getClass().getName() + " usando before");
    }
    
    public void principalBefore(Integer unInteger) {
        LOGGER.info("En " + getClass().getName() + " usando before con un parámetro, cuyo valor es " + unInteger);
    }

    public void metodoLento() {
        for (int i = 0; i < 1000000; i++)
            Math.random();
    }
}
