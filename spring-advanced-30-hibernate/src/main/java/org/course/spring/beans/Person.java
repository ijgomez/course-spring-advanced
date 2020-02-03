package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Person implements Serializable {

	private static final long serialVersionUID = -5871675207226413225L;
	
	private Integer id;
	
	private String nombre;
	
	private Set<Hobby> aficionesInternas;
	
	private List<Hobby> aficiones;

}
