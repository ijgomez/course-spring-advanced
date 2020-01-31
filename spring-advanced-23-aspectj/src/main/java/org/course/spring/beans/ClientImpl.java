package org.course.spring.beans;

import java.io.Serializable;
import java.util.List;

public class ClientImpl implements Serializable, Client {

	private static final long serialVersionUID = 1L;

	public List<Account> getCuentas() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Account getCuenta(Long cuentaId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setNombre(String nombre) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}