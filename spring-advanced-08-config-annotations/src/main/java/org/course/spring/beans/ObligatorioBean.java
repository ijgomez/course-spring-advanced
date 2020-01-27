package org.course.spring.beans;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Required;

public class ObligatorioBean implements Serializable {

	private static final long serialVersionUID = -8603304851074602802L;
	
	private String texto;

    public ObligatorioBean() {
    }

    public String getTexto() {
        return texto;
    }

    @Required
    public void setTexto(String texto) {
        this.texto = texto;
    }
}
