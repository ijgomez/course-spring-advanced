package org.course.spring;

import org.course.spring.beans.Client;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExerciseTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testExercise() throws Exception {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" })) {
			LOGGER.info("Context loaded.");
			
			Client client = (Client) ctx.getBean("client");
			
			LOGGER.info("{}", client.getName());
		}
	}

}
