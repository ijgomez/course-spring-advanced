package org.course.spring.commands;

import org.course.spring.beans.User;
import org.course.spring.utils.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InstanciarBeanCommand implements Command {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InstanciarBeanCommand.class);

    public void execute() {
    	
    	try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext0002.xml"})) {

            LOGGER.info("Context loaded.");
            
            
            String literal = (String) ctx.getBean("unLiteral");
            LOGGER.info("Valor del bean: {}", literal);
            
            User user1 = (User) ctx.getBean("usuario1");
            LOGGER.info(String.format("Datos del usuario1:\n\tNombre:%s\n\tClave:%s\n\tEdad:%s\n",user1.getName(),user1.getPassword(),user1.getAge()));
            
            User user2 = (User) ctx.getBean("usuario2");
            LOGGER.info(String.format("Datos del usuario2:\n\tNombre:%s\n\tClave:%s\n\tEdad:%s\n",user2.getName(),user2.getPassword(),user2.getAge()));	
    	}
    }
    
}
