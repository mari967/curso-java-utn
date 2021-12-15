package com.mc.questionados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.questionados.dto.PreguntaDto;
import com.mc.questionados.entity.Pregunta;
import com.mc.questionados.response.GenericResponse;
import com.mc.questionados.service.PreguntaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation; 

@RestController
@Api(tags = "Preguntas")  //Swagger

@RequestMapping("/preguntas")
public class PreguntaController {
	
	@Autowired
	PreguntaService preguntaService;

	@ApiOperation(value = "Obtener todas las preguntas")//Swagger
	@GetMapping
	public ResponseEntity<Iterable<Pregunta>> get() {
		return ResponseEntity.ok(preguntaService.get());
	}
	

	@ApiOperation(value = "Obtener categoria por id")//Swagger
	@GetMapping("/{preguntaId}")
	public ResponseEntity<?> getById(@PathVariable("preguntaId") Long preguntaId) {
		
		if(preguntaService.existById(preguntaId)) {
			return ResponseEntity.ok(preguntaService.get(preguntaId));
			
		} else {
			GenericResponse respuesta = new GenericResponse();
			respuesta.setIsOK(false);
			respuesta.setMensaje("No se encontró la pregunta con el id " + preguntaId);
			
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	
	@ApiOperation(value = "Crear una pregunta")//Swagger
	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody PreguntaDto dto) {
		GenericResponse respuesta = new GenericResponse();
		//Crear categoria
		Pregunta categoriaNueva = preguntaService.create(dto);
		//Envía detalles de la pregunta creada en la respuesta
		respuesta.setIsOK(true);
		respuesta.setMensaje("Pregunta creada con éxito");
		respuesta.setId(categoriaNueva.getPregunta_id());
		
		return ResponseEntity.ok(respuesta);
	}
	
	
	@ApiOperation(value = "Eliminar una pregunta")//Swagger
	@DeleteMapping("/{preguntaId}")
	public ResponseEntity<String> delete(@PathVariable("preguntaId") Long preguntaId) {
		if(preguntaService.existById(preguntaId)) {
			preguntaService.delete(preguntaId);
			return ResponseEntity.ok("Pregunta con id " + preguntaId + " borrada");
		}
		return ResponseEntity.badRequest().body("No se encontró la pregunta con el id " + preguntaId);
	}
	
	
	@ApiOperation(value = "Actualizar un pregunta")//Swagger
	@PutMapping("/{preguntaId}")
	public ResponseEntity<GenericResponse> update(@PathVariable("preguntaId") Long preguntaId, @RequestBody PreguntaDto dto) {
		
		GenericResponse respuesta = new GenericResponse();
		
		if(preguntaService.existById(preguntaId)) {
			Pregunta categoriaActualizado = preguntaService.update(dto);

			respuesta.setId(categoriaActualizado.getPregunta_id());
			respuesta.setIsOK(true);
			respuesta.setMensaje("Pregunta actualizada correctamente");
			
			return ResponseEntity.ok(respuesta);
		}
		respuesta.setId(preguntaId);
		respuesta.setIsOK(false);
		respuesta.setMensaje("La pregunta no existe");
		return ResponseEntity.badRequest().body(respuesta);
	}
}
