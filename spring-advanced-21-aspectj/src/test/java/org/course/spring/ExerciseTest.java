package org.course.spring;

import org.course.spring.beans.Message;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExerciseTest.class);

	@Test
	public void testExercise() {
		Message mensaje = new Message();
        mensaje.setText("abc");
        LOGGER.info("Texto del mensaje: " + mensaje.getText() );
	}

	
}
