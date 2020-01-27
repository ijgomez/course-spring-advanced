package org.course.spring.beans;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class ResourceBean implements Serializable {

	private static final long serialVersionUID = -2584268316083931231L;

	@Resource
	private String nombre;
	
	@Resource(name = "obligatorioBean1")
	private ObligatorioBean obligatorioBean;

	public ObligatorioBean getObligatorioBean() {
		return obligatorioBean;
	}

	public void setObligatorioBean(ObligatorioBean obligatorioBean) {
		this.obligatorioBean = obligatorioBean;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@PostConstruct
	private void despuesDeConstruir() {
		String s = String.format("El bean %s acaba de ser construido", getClass().getName());
		System.out.println(s);
	}

	@PreDestroy
	void antesDeDestruir() {
		String s = String.format("El bean %s va a ser destruido", getClass().getName());
		System.out.println(s);
	}
}
