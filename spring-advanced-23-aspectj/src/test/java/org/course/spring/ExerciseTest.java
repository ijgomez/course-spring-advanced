package org.course.spring;

import org.course.spring.beans.ClientImpl;
import org.course.spring.beans.AccountImpl;
import org.course.spring.services.ClientService;
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
	
	private ClientService clienteService;

	@Before
	public void beforeTest() {
		clienteService = (ClientService) ctx.getBean("clienteService");
	}

	@Test
	public void testForzarEjecucionAspectoAfterReturning() throws Exception {
		clienteService.ingresar(new ClientImpl(), new AccountImpl(), 6000.0d);
		clienteService.reintegrar(new ClientImpl(), new AccountImpl(), 5000.0d);
    }

	
	
}
