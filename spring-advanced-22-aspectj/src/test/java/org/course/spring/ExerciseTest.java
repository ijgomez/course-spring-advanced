package org.course.spring;

import org.course.spring.beans.EjemploIntroduccion;
import org.course.spring.beans.Persona;
import org.course.spring.services.SaludoService;
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
	
	private SaludoService saludoService;

	@Before
	public void beforeTest() {
		saludoService = (SaludoService) ctx.getBean("saludoService");
	}

	@Test
	public void testForzarEjecucionAspectoAfterReturning() throws Exception {
        saludoService.principalAfterReturning();
    }

	@Test
	public void testForzarEjecucionAspectoBefore() throws Exception {
        saludoService.principalBefore();
    }

    @Test
	public void testForzarEjecucionAspectoAfter() throws Exception {
        saludoService.principalAfter();
    }

    @Test(expected = Exception.class)
	public void testForzarEjecucionAspectoAfterThrowing() throws Exception {
        saludoService.metodoPublicoCualquiera();
    }

    @Test
	public void testForzarEjecucionAspectoAround() throws Exception {
        saludoService.metodoLento();
    }

    @Test
	public void testForzarEjecucionAspectoBeforeConParametro() throws Exception {
        saludoService.principalBefore(7);
    }

    @Test
	public void testForzarEjecucionAspectoIntroduccion() throws Exception {
        Persona persona = (Persona) ctx.getBean("persona");
        persona.setNombre("Un nombre");
        EjemploIntroduccion ej = (EjemploIntroduccion) ctx.getBean("persona");
        ej.mensaje();
    }
	
}
