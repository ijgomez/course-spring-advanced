package org.course.spring.components;

import java.io.Serializable;
import org.springframework.stereotype.Component;

@Component
public class ComponenteBean implements Serializable {

	private static final long serialVersionUID = -901510482100513069L;

	private String nombre = "Auto Scan";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
