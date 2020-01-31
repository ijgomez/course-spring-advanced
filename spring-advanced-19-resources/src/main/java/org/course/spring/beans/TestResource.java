package org.course.spring.beans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

public class TestResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestResource.class);

    private Resource recurso;

    public void imprimirFrase() {
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(recurso.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String frase = null;
            while ((frase = br.readLine()) != null) {
                LOGGER.info("Frase: {}", frase);
            }
        } catch (IOException ex) {
            LOGGER.error("{}", ex, ex);
        } finally {
            try {
                isr.close();
            } catch (IOException ex) {
            	LOGGER.error("{}", ex, ex);
            }
        }
    }
    
    public Resource getRecurso() {
        return recurso;
    }

    public void setRecurso(Resource recurso) {
        this.recurso = recurso;
    }
}
