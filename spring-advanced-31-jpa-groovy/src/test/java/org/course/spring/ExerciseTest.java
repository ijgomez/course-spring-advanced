package org.course.spring;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExerciseTest {

	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void init() throws Exception {
		ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		log.info("Contexto cargado");

	}

	@AfterClass
	public static void close() throws Exception {
		ctx.close();
	}
	
	@Before
	public void beforeTest() throws Exception {
		
	}

	@Test
	public void testExercise() throws Exception {
        
    }

}
