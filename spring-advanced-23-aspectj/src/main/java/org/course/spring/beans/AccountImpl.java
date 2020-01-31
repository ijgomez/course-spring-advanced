package org.course.spring.beans;

import java.io.Serializable;

public class AccountImpl implements Serializable, Account {

	private static final long serialVersionUID = 1L;

	public Client getCliente() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double getSaldo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ingresar(Double importe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double reintegrar(Double importe) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}