package org.course.spring.commands;

import org.course.spring.beans.Employee;
import org.course.spring.utils.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InyectarBeanCommand implements Command {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(InyectarBeanCommand.class);

    public void execute() {
    	
    	try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"applicationContext0005.xml", "applicationContext0006.xml"})) {

            LOGGER.info("Context loaded.");
            
           
            Employee employee1 = (Employee) ctx.getBean("empleado1");
            LOGGER.info(String.format("Datos del empleado1:\n\tNombre:%s\n\tClave:%s\n\tEdad:%d\n\tImporte de la nómina:%f\n",employee1.getName(),employee1.getPassword(),employee1.getAge(),employee1.getPayroll().getAmount()));
            
            Employee employee2 = (Employee) ctx.getBean("empleado2");
            LOGGER.info(String.format("Datos del empleado2:\n\tNombre:%s\n\tClave:%s\n\tEdad:%d\n\tImporte de la nómina:%f\n",employee2.getName(),employee2.getPassword(),employee2.getAge(),employee2.getPayroll().getAmount()));
        
    	}
    }
    
}
