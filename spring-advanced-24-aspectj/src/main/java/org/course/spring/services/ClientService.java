package org.course.spring.services;

import org.course.spring.annotations.Fiscalizable;
import org.course.spring.annotations.Registrable;
import org.course.spring.beans.Client;
import org.course.spring.beans.Acount;



public interface ClientService {
	
	Client getCliente(Long id);

	@Registrable
	@Fiscalizable
	void ingresar(Client client, Acount acount, Double amount);

	@Registrable(siHayError = true)
	public Double reintegrar(Client client, Acount acount, Double amount);

	public Double getSaldoMedio(Client client);
}
