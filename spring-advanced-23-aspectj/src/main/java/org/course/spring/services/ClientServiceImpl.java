package org.course.spring.services;

import java.io.Serializable;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;

public class ClientServiceImpl implements Serializable, ClientService {

	private static final long serialVersionUID = 1L;

	public Client getCliente(Long clienteId) {
		return null;
	}

	@Registrable
	@Fiscalizable
	public void ingresar(Client cliente, Account cuenta, Double importe) {
	}

	@Registrable(siHayError = true)
	public Double reintegrar(Client cliente, Account cuenta, Double importe) {
		return null;
	}

	public Double getSaldoMedio(Client cliente) {
		return null;
	}
}