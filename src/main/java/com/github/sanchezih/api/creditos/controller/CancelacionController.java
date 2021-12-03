package com.github.sanchezih.api.creditos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.github.sanchezih.api.creditos.entities.Cancelacion;
import com.github.sanchezih.api.creditos.entities.Prestamo;
import com.github.sanchezih.api.creditos.models.request.InfoCancelacionNueva;
import com.github.sanchezih.api.creditos.models.response.GenericResponse;
import com.github.sanchezih.api.creditos.service.CancelacionService;
import com.github.sanchezih.api.creditos.service.PrestamoService;

@RestController
public class CancelacionController {

	@Autowired
	CancelacionService service;

	@Autowired
	PrestamoService prestamoService;

	@PostMapping("/cancelaciones")
	public ResponseEntity<?> crearCancelacion(@RequestBody InfoCancelacionNueva infoCancelacionNueva) {
		GenericResponse respuesta = new GenericResponse();
		Cancelacion cancelacion = new Cancelacion(infoCancelacionNueva.importeCuota, infoCancelacionNueva.numeroCuota,
				infoCancelacionNueva.fechaCancelacion);
		Prestamo prestamo = prestamoService.traerPrestamoPorId(infoCancelacionNueva.prestamoId);
		cancelacion.setPrestamo(prestamo);
		service.crear(cancelacion);
		respuesta.id = cancelacion.getId();
		respuesta.isOk = true;
		respuesta.message = "La cancelacion ha sido creada con exito";
		return ResponseEntity.ok(respuesta);
	}

	@GetMapping("/cancelaciones/prestamos/{idPrestamo}")
	public ResponseEntity<List<Cancelacion>> traerCancelacionesPorPrestamoId(@PathVariable int idPrestamo) {
		return ResponseEntity.ok(service.traerCancelacionesPorPrestamoId(idPrestamo));
	}

}
