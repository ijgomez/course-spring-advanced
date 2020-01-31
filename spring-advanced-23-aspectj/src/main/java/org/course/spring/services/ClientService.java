package org.course.spring.services;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Account;

public interface ClientService {
	
	Client getCliente(Long clienteId);

	@Registrable
	@Fiscalizable
	void ingresar(Client cliente, Account cuenta, Double importe);

	@Registrable(siHayError = true)
	public Double reintegrar(Client cliente, Account cuenta, Double importe);

	public Double getSaldoMedio(Client cliente);
}
