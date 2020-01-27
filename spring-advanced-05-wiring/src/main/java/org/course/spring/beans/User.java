package org.course.spring.beans;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -1106504108226034428L;
	
	public static User create(){
        return new User("pepe");
    }
	
	private String name;
	
	/**
	 * New Instance
	 */
	public User() {
		this.name = "Sin nombre";
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}