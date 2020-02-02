package org.course.spring.beans;

import java.io.Serializable;

public interface IContacto extends Serializable {
    public void setId(Integer id);

    public Integer getId();

    public void setNombre(String nombre);

    public String getNombre();

    public void setComentario(String comentario);

    public String getComentario();
}
