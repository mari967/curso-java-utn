package com.github.sanchezih.api.creditos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.sanchezih.api.creditos.entities.Cancelacion;
import com.github.sanchezih.api.creditos.entities.Prestamo;
import com.github.sanchezih.api.creditos.repos.CancelacionRepository;

@Service
public class CancelacionService {

	@Autowired
	CancelacionRepository CancelacionRepository;

	@Autowired
	PrestamoService prestamoService;

	public void crear(Cancelacion cancelacion) {
		Prestamo prestamo = new Prestamo();
		CancelacionRepository.save(cancelacion);
		prestamo.agregarCancelacion(cancelacion);
	}

	public List<Cancelacion> traerCancelacionesPorPrestamoId(int prestamoId) {
		Prestamo prestamo = prestamoService.traerPrestamoPorId(prestamoId);
		return prestamo.getCancelaciones();
	}
}
