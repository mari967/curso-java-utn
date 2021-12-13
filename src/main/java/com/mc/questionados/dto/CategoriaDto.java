package com.mc.questionados.dto;

public class CategoriaDto {
	private long categoria_id;
	private String descripcion;
	private String nombre;
	
	
	
	public long getCategoria_id() {
		return categoria_id;
	}
	
	public void setCategoria_id(long categoria_id) {
		this.categoria_id = categoria_id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
