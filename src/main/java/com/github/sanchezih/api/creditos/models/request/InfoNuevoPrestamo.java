package com.github.sanchezih.api.creditos.models.request;

import java.math.BigDecimal;
import java.util.Date;

import com.github.sanchezih.api.creditos.entities.Prestamo.EstadoPrestamoEnum;

public class InfoNuevoPrestamo {

	public int clienteId;
	public Date fecha;
	public BigDecimal importe;
	public int cuotas;
	public Date fechaAlta;
	public EstadoPrestamoEnum estado;
}
