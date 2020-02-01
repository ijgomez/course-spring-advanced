package org.course.spring;

import org.course.spring.beans.Client;
import org.course.spring.services.ClientService;
import org.course.spring.beans.Acount;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");
	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	private ClientService clientService;

	@Before
	public void beforeTest() {
		clientService = (ClientService) ctx.getBean("clientService");
	}

	@Test
	public void testForzarEjecucionAspectoAfterReturning() throws Exception {
        clientService.ingresar(new Client(),new Acount(),6000.0d);
        clientService.reintegrar(new Client(),new Acount(),5000.0d);
    }

	
	
}
