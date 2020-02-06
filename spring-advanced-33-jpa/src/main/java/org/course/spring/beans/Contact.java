package org.course.spring.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Contact implements Serializable {

	private static final long serialVersionUID = -2286830236408421949L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Comercial comercial;

	private String nombre;

	/** Creates a new instance of Contact */
	public Contact() {
	}

	public Contact(String nombre) {
		this.nombre = nombre;
	}

}
