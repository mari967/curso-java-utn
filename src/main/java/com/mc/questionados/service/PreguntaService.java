package com.mc.questionados.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.questionados.dto.PreguntaDto;
import com.mc.questionados.entity.Pregunta;
import com.mc.questionados.repository.PreguntaRepo;

@Service
public class PreguntaService {
	@Autowired
	PreguntaRepo preguntaRepo;	
	
	public Pregunta get(long id) {
		Optional<Pregunta> preguntaResult = preguntaRepo.findById(id);
		if(preguntaResult.isPresent())
			return preguntaResult.get();
		return null;
		
	}
	
	public Iterable<Pregunta> get() {
		Iterable<Pregunta> preguntasResult = preguntaRepo.findAll();
		return preguntasResult;
		
	}
	
	public Pregunta create(PreguntaDto dto) {
		Pregunta preguntaNueva = new Pregunta();
		preguntaNueva.setEnunciado(dto.getEnunciado());
		
		preguntaRepo.save(preguntaNueva);
		return preguntaNueva;
		
	} 
	
	public Pregunta update(PreguntaDto dto) {
		Optional<Pregunta> pregunta = preguntaRepo.findById(dto.getPregunta_id());
		if(pregunta.isPresent()) {
			Pregunta preguntaActualizacion = pregunta.get();
			preguntaActualizacion.setEnunciado(dto.getEnunciado().isEmpty() || dto.getEnunciado() == null ? preguntaActualizacion.getEnunciado() : dto.getEnunciado());
		
			
			preguntaRepo.save(preguntaActualizacion);
			return preguntaActualizacion;
		}
		
		return null;
		
	}
	
	
	public void delete(long id) {
		if(this.existById(id)) {
			preguntaRepo.deleteById(id);
		}
	}
	
	public Boolean existById(Long id) {
		Pregunta resultado = this.get(id);
		return resultado != null;
	}
	
	
	
	
}
