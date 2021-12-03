package com.github.sanchezih.api.creditos.excepciones;

import com.github.sanchezih.api.creditos.entities.*;

public class ClienteDNIException extends ClienteInfoException {

	public ClienteDNIException(Cliente cliente, String mensaje) {
		super(cliente, mensaje);
	}
}
