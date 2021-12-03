package com.github.sanchezih.api.creditos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.sanchezih.api.creditos.entities.Prestamo;
import com.github.sanchezih.api.creditos.models.request.InfoEstadoPrestamo;
import com.github.sanchezih.api.creditos.models.request.InfoNuevoPrestamo;
import com.github.sanchezih.api.creditos.models.response.GenericResponse;
import com.github.sanchezih.api.creditos.service.ClienteService;
import com.github.sanchezih.api.creditos.service.PrestamoService;

@RestController
public class PrestamoController {
	@Autowired
	PrestamoService prestamoService;
	
	@Autowired
	ClienteService clienteService;

	@PostMapping("/prestamos")
	public ResponseEntity<GenericResponse> crearPrestamo(@RequestBody InfoNuevoPrestamo infoPrestamo) {
		GenericResponse respuesta = new GenericResponse();
		Prestamo prestamoNuevo = prestamoService.crearPrestamo(infoPrestamo.clienteId, infoPrestamo.fecha, infoPrestamo.importe,
				infoPrestamo.cuotas, infoPrestamo.fechaAlta, infoPrestamo.estado);
		respuesta.isOk = true;
		respuesta.id = prestamoNuevo.getPrestamoId();
		respuesta.message = "El prestamo fue creado con exito";
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/prestamos/clientes/{idCliente}")
	public ResponseEntity<List<Prestamo>> traerPrestamosPorClienteId(@PathVariable int idCliente) {
		return ResponseEntity.ok(prestamoService.traerPrestamos(idCliente));
	}

	@PutMapping("/prestamos/{id}")
	public ResponseEntity<GenericResponse> actualizarPrestamo(@PathVariable int id,
			@RequestBody InfoEstadoPrestamo estadoPrestamo) {
		GenericResponse respuesta = new GenericResponse();
		Prestamo prestamo = prestamoService.traerPrestamoPorId(id);
		prestamo.setEstadoId(estadoPrestamo.estadoPrestamo);
		prestamoService.actualizarPrestamo(prestamo);
		respuesta.id = prestamo.getPrestamoId();
		respuesta.isOk = true;
		respuesta.message = "El estado del prestamo ha sido actualizado exitosamente";
		return ResponseEntity.ok(respuesta);
	}
}
