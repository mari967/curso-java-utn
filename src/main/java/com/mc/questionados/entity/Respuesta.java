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
public class Respuesta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long respuesta_id;
	
	@Column
	private String texto;
	
	@Column(nullable = false)
	private boolean es_correcta;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pregunta_id", nullable = false)
	private Pregunta pregunta;
}
