package org.course.spring.beans;

public class Contacto implements IContacto {
    private Integer id;
    private String nombre;
    private String comentario;

    public Contacto() {
    }

    public Contacto(String nombre, String comentario) {
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
