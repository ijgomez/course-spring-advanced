package org.course.spring;

import org.course.spring.utils.CommandFactory;
import org.course.spring.utils.CommandType;
import org.junit.Test;

public class ExerciseTest {

	@Test
	public void testLOAD_CONTEXT() throws Exception {

        CommandFactory.getInstance().getCommand(CommandType.LOAD_CONTEXT).execute();
        
	}
	
	@Test
	public void testINSTANCE_BEAN() throws Exception {

        CommandFactory.getInstance().getCommand(CommandType.INSTANCE_BEAN).execute();
        
	}
	
	@Test
	public void testINYECTION_BEAN() throws Exception {

        CommandFactory.getInstance().getCommand(CommandType.INYECTION_BEAN).execute();
        
	}

}
