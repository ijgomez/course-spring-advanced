package org.course.spring.beans;

public class UsuarioImpl implements Usuario{

    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
