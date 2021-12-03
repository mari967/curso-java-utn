package com.github.sanchezih.api.creditos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.sanchezih.api.creditos.entities.Cliente;
import com.github.sanchezih.api.creditos.models.request.InfoDireccionCliente;
import com.github.sanchezih.api.creditos.models.response.GenericResponse;
import com.github.sanchezih.api.creditos.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> traerTodos() {
		return ResponseEntity.ok(clienteService.traerTodos());
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> traerClientePorId(@PathVariable Integer id) {
		GenericResponse respuesta = new GenericResponse();
		if (clienteService.existePorId(id)) {
			return ResponseEntity.ok(clienteService.traerClientePorId(id));
		} else {
			respuesta.isOk = false;
			respuesta.message = "El cliente no existe";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
		GenericResponse respuesta = new GenericResponse();
		if (clienteService.crearCliente(cliente)) {
			respuesta.isOk = true;
			respuesta.id = cliente.getClienteId();
			respuesta.message = "El cliente fue creado con exito";
			return ResponseEntity.ok(respuesta);

		} else {
			respuesta.isOk = false;
			respuesta.message = "El cliente ya existe";
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	@PutMapping("/clientes/{id}/direccion")
	public ResponseEntity<GenericResponse> actualizarCliente(@PathVariable int id,
			@RequestBody InfoDireccionCliente direccionNueva) {
		GenericResponse respuesta = new GenericResponse();
		if (clienteService.existePorId(id)) {
			Cliente clienteActualizado = clienteService.traerClientePorId(id);
			clienteActualizado.setDireccion(direccionNueva.direccion);
			clienteActualizado.setDireccionAlternativa(direccionNueva.direccionAlternativa);
			clienteService.actualizarCliente(clienteActualizado);
			respuesta.isOk = true;
			respuesta.id = clienteActualizado.getClienteId();
			respuesta.message = "La direccion del cliente ha sido actualizada correctamente";
			return ResponseEntity.ok(respuesta);
		} else {
			respuesta.isOk = false;
			respuesta.message = "El cliente no existe";
			return ResponseEntity.badRequest().body(respuesta);
		}

	}

}
