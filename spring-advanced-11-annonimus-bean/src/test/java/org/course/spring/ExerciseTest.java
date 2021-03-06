package org.course.spring;

import org.course.spring.beans.Person;
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
	public void testExercise() {
        for (String name : ctx.getBeanDefinitionNames()) {
            LOGGER.info(name);
        }
        Person person = (Person) ctx.getBean("org.course.spring.beans.Person");
        LOGGER.info(person.getName());
        
        Person person1 = (Person) ctx.getBean("org.course.spring.beans.Person#1");
        LOGGER.info(person1.getName());
	}

	
}
