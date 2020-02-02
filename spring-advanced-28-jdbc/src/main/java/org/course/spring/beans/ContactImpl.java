package org.course.spring.beans;

public class ContactImpl implements Contact {

	private static final long serialVersionUID = 4495774296731360661L;

	private Integer id;
	
	private String nombre;
	
	private String comentario;

	public ContactImpl() {
		
	}

	public ContactImpl(String nombre, String comentario) {
		setNombre(nombre);
		setComentario(comentario);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}
}
