package org.course.spring;

import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testExercise() throws Exception {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" })) {
			LOGGER.info("Context loaded.");
			

	        MessageSource fuente = (MessageSource)ctx.getBean("messageSource");
	        String mensajeUnoEs = fuente.getMessage("m1", null, Locale.getDefault());
	        String mensajeDosES = fuente.getMessage("m2", new Object[]{new Date(), new Date()}, Locale.getDefault());
	        String mensajeUnoEn = fuente.getMessage("m1", null, new Locale("en", "GB"));
	        String mensajeDosEn = fuente.getMessage("m2", new Object[]{new Date(), new Date()}, new Locale("en","GB"));
	        
	        LOGGER.info("Mensajes en castellano");
	        LOGGER.info(String.format("Mensaje número uno: %s", mensajeUnoEs));
	        LOGGER.info(String.format("Mensaje número dos: %s", mensajeDosES));
	        LOGGER.info("Mensajes en inglés");
	        LOGGER.info(String.format("Mensaje número uno: %s", mensajeUnoEn));
	        LOGGER.info(String.format("Mensaje número dos: %s", mensajeDosEn));
	   
		}
	}

}
