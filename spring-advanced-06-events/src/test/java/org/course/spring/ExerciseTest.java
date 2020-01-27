package org.course.spring;

import org.course.spring.events.MyApplicationContextAware;
import org.course.spring.lifecicle.UserFactoryBean;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	private static ClassPathXmlApplicationContext ctx;
	
	@BeforeClass
	public static void beforeClass() {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		LOGGER.info("Contexto cargado");

		ctx.registerShutdownHook();
	}
	
	@Test
	public void testProbarFactoria() throws Exception  {
		UserFactoryBean factoriaUsuarioBean = (UserFactoryBean) ctx.getBean("factoriaUsuarioBean");
        LOGGER.info("Primer usuario:{}", factoriaUsuarioBean.getNewUser());
        LOGGER.info("Segundo usuario:{}", factoriaUsuarioBean.getNewUser());
	}
	
	@Test
	public void testProvocarEvento() throws Exception  {
		MyApplicationContextAware demoBean = (MyApplicationContextAware) ctx.getBean("demoBean");
        demoBean.generarEvento();
	}

}
