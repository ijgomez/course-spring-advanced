package org.course.spring.beans;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User implements Serializable {

	private static final long serialVersionUID = -1106504108226034428L;
	
	public static User create(){
        return new User();
    }
	
	private String name;
	
	private String password;
	
	private Integer age;

	/**
	 * New Instance
	 */
	public User() {
	}
}