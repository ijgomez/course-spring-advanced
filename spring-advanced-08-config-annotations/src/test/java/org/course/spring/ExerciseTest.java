package org.course.spring;

import org.course.spring.beans.AutoBean;
import org.course.spring.beans.ObligatorioBean;
import org.course.spring.beans.ResourceBean;
import org.course.spring.components.ComponenteBean;
import org.course.spring.services.ScanService;
import org.junit.AfterClass;
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

	@Test
	public void testComponent() {
		ComponenteBean c = (ComponenteBean) ctx.getBean("componenteBean");
		LOGGER.info("El componente es " + c.getClass().getName());
		
		ScanService t = (ScanService) ctx.getBean(ScanService.class);
		LOGGER.info("Test: " + t.getC().getNombre());
	}

	@Test
	public void testRequired() {
		ObligatorioBean ob = (ObligatorioBean) ctx.getBean("obligatorioBean");
		
		LOGGER.info("Texto inyectado en el bean: " + ob.getTexto());
	}

	@Test
	public void testAutoWire() {
		AutoBean a = (AutoBean) ctx.getBean("autoBean");
		
		LOGGER.info("Nombre: " + a.getNombre());
		LOGGER.info("Colaborador: " + a.getObligatorioBean().getTexto());
		LOGGER.info("ApplicationContext: " + a.getContext().getDisplayName());
	}

	@Test
	public void testResource() {
		ResourceBean r = (ResourceBean) ctx.getBean("resourceBean");
		
		LOGGER.info("El texto es: " + r.getNombre());
		LOGGER.info("ObligatorioBean: " + r.getObligatorioBean().getTexto());
	}
}
