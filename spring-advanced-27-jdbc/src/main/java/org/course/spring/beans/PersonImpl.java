package org.course.spring.beans;

import java.io.Serializable;

public class PersonImpl implements Person, Serializable {

	private static final long serialVersionUID = -8216371842958292168L;
	
	private Integer id;
	
	private String nombre;

	/** Creates a new instance of PersonImpl */
	public PersonImpl() {
	}

	public PersonImpl(Integer id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	@Override
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
