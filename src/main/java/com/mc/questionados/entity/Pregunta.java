package com.mc.questionados.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pregunta_id;
	
	@Column(nullable = false)
	private String enunciado;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_pregunta_id", nullable = false)
	private Categoria categoria;
	
	
	
	
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
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
