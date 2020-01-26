package org.course.spring.beans;

import java.io.Serializable;

import lombok.Data;

@Data
public class Client implements Serializable {

	private static final long serialVersionUID = -6769250364850034035L;
	
	private String name;
	
	private Account account; 
	
}
