package com.mc.questionados.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@Api(tags = "Tests de acceso por roles")  //Swagger
public class TestController {
	
	//Atiende reuqest de prueba

	
	@GetMapping("/all")
	@ApiOperation(value = "Contenido con acceso publico")//Swagger
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@ApiOperation(value = "Contenido con acceso para los roles USER, MODERADOR o ADMIN")//Swagger
	public String userAccess() {
		return "User Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	@ApiOperation(value = "Contenido con acceso para el rol MODERADOR")//Swagger
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	@ApiOperation(value = "Contenido de acceso para el rol ADMIN")//Swagger
	public String adminAccess() {
		return "Admin Board.";
	}
}
