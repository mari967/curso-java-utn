package com.github.sanchezih.api.creditos.excepciones;

import com.github.sanchezih.api.creditos.entities.*;

public class ClienteInfoException extends Exception {
	private Cliente cliente;

	public ClienteInfoException(Cliente cliente, String mensaje) {
		super(cliente.getNombre() + ":" + mensaje);
		this.cliente = cliente;
	}
}