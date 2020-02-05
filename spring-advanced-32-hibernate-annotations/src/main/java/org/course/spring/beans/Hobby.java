package org.course.spring.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Hobby {
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@ManyToOne
	private Person person;

}
