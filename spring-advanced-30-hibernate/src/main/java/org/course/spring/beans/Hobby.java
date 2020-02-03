package org.course.spring.beans;

import lombok.Data;

@Data
public class Hobby {
	
	private Integer id;
	
	private String nombre;
	
	private Person person;

}
