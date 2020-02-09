package org.course.spring.beans;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Persona implements Serializable {

	private static final long serialVersionUID = 3114293688811416980L;
	
	@Autowired(required = true)
    @Qualifier("nombre")
    private String nombre;
	
    @Autowired(required = true)
    @Qualifier("apellido")
    private String apellido;

    public Persona() {
    	
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

}
