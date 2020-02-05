package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = -5871675207226413225L;
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private String nombre;

	@OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Hobby> hobbies;

}
