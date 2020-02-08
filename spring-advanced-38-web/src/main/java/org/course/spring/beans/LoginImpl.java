package org.course.spring.beans;

public class LoginImpl implements Login {
    
	private String nombre;
    
	private String clave;

    public LoginImpl() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
