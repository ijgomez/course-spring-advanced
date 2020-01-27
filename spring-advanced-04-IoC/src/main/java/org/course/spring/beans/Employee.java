package org.course.spring.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee extends User {

	private static final long serialVersionUID = -5809987521124914876L;

	private Payroll payroll;
	
	/**
	 * New Instance
	 */
	public Employee() {
		
	}
	
	public void init(){
        System.out.println("Método de inicialización invocado");
    }
	
    public void destroy(){
        System.out.println("Método de destrucción invocado");
    }
}
