package org.course.spring;

import org.course.spring.services.TestInheritance;
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
	
	private TestInheritance t;

	@Before
	public void beforeTest() {
		t = (TestInheritance) ctx.getBean("testHerencia");
	}

	@Test
	public void testExercise() throws Exception {
        t.test();
    }

	
	
}
