package org.course.spring;

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
		}
	}

}
