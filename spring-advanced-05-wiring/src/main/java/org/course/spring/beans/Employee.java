package org.course.spring.beans;

public class Employee extends User {

	private static final long serialVersionUID = -5809987521124914876L;

	private int salary = 1000;
	
	/**
	 * New Instance
	 */
	public Employee() {
		
	}

	public Employee(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
