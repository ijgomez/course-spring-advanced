package org.course.spring.beans;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

public class AutoBean implements Serializable {

	private static final long serialVersionUID = -6466950957024620011L;
	
	@Autowired
    @Qualifier(value = "no_especial")
    private ObligatorioBean obligatorioBean;
    
	@Autowired
    @Qualifier(value = "especial")
    private ObligatorioBean obligatorioBean1;
    
	private String nombre;
    
	@Autowired
    private ApplicationContext context;

    public ObligatorioBean getObligatorioBean1() {
        return obligatorioBean1;
    }

    public void setObligatorioBean1(ObligatorioBean obligatorioBean1) {
        this.obligatorioBean1 = obligatorioBean1;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    public String getNombre() {
        return nombre;
    }

    @Autowired(required = false)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObligatorioBean getObligatorioBean() {
        return obligatorioBean;
    }

    public void setObligatorioBean(ObligatorioBean obligatorioBean) {
        this.obligatorioBean = obligatorioBean;
    }
}
