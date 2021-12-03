package com.github.sanchezih.api.creditos.excepciones;

import com.github.sanchezih.api.creditos.entities.*;

public class ClienteEdadException extends ClienteInfoException {
	public ClienteEdadException(Cliente cliente, String mensaje) {
		super(cliente, mensaje);
	}
}
