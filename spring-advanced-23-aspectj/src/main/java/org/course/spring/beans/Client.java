package org.course.spring.beans;

import java.util.List;

public interface Client {
	
	List<Account> getCuentas();

	Account getCuenta(Long cuentaId);

	void setNombre(String nombre);

	String getNombre();
	
}
