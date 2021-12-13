package com.mc.questionados.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.questionados.dto.CategoriaDto;
import com.mc.questionados.entity.Categoria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.mc.questionados.response.GenericResponse;
import com.mc.questionados.service.CategoriaService; 

@RestController(value ="/categorias")
@Api(tags = "Categorias")  //Swagger

@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;

	@ApiOperation(value = "Obtener todas las categorias")//Swagger
	@GetMapping
	public ResponseEntity<Iterable<Categoria>> get() {
		return ResponseEntity.ok(categoriaService.get());
	}
	

	@ApiOperation(value = "Obtener categoria por id")//Swagger
	@GetMapping
	@RequestMapping("/{categoriaId}")
	public ResponseEntity<?> getById(@PathVariable("categoriaId") Long categoriaId) {
		
		if(categoriaService.existById(categoriaId)) {
			return ResponseEntity.ok(categoriaService.get(categoriaId));
			
		} else {
			GenericResponse respuesta = new GenericResponse();
			respuesta.setIsOK(false);
			respuesta.setMensaje("No se encontró la categoría con el id " + categoriaId);
			
			return ResponseEntity.badRequest().body(respuesta);
		}
	}

	
	@ApiOperation(value = "Crear una categoría")//Swagger
	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody CategoriaDto dto) {
		GenericResponse respuesta = new GenericResponse();
		//Crear categoria
		Categoria categoriaNueva = categoriaService.create(dto);
		//Envía detalles de la categoría creada en la respuesta
		respuesta.setIsOK(true);
		respuesta.setMensaje("Categoria creada con éxito");
		respuesta.setId(categoriaNueva.getCategoria_id());
		
		return ResponseEntity.ok(respuesta);
	}
	
	
	@ApiOperation(value = "Eliminar una categoría")//Swagger
	@DeleteMapping
	@RequestMapping("{categoriaId}")
	public ResponseEntity<String> delete(@PathVariable("categoriaId") Long categoriaId) {
		if(categoriaService.existById(categoriaId)) {
			categoriaService.delete(categoriaId);
			return ResponseEntity.ok("Categoria con id " + categoriaId + " borrada");
		}
		return ResponseEntity.badRequest().body("No se encontró la categoría con el id " + categoriaId);
	}
	
	
	@ApiOperation(value = "Actualizar un categoría")//Swagger
	@PutMapping
	public ResponseEntity<Categoria> update() {
		return Arrays.asList("Ciencia", "Literatura", "Musica");
	}
}
