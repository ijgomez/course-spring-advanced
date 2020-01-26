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
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml", "applicationContext1.xml" })) {
			LOGGER.info("Context loaded.");
			
			Client client1 = (Client) ctx.getBean("client");
			
			LOGGER.info("{}", client1);
			
			Client client2 = (Client) ctx.getBean("client");
			
			LOGGER.info("{}", client2);
			LOGGER.info("{}", client2.getName());
			LOGGER.info("{}", client2.getAccount().getAmount());
	        
			Client client3 = (Client) ctx.getBean("clientWithProps");
			
			LOGGER.info("{}", client3.getName());

		}
	}

}
