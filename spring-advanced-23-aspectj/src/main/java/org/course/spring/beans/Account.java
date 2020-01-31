package org.course.spring.beans;

public interface Account {
	
	Client getCliente();

	Double getSaldo();

	void ingresar(Double importe);

	Double reintegrar(Double importe);
}
