package com.mc.questionados.dto;

public class PreguntaDto {
	private long pregunta_id;
	private String enunciado;
	private long categoria_id;
	
	
	
	public long getPregunta_id() {
		return pregunta_id;
	}
	
	public void setPregunta_id(long pregunta_id) {
		this.pregunta_id = pregunta_id;
	}
	
	public String getEnunciado() {
		return enunciado;
	}
	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public long getCategoria_id() {
		return categoria_id;
	}
	
	public void setCategoria_id(long categoria_id) {
		this.categoria_id = categoria_id;
	}
	
}
