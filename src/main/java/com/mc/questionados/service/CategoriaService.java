package com.mc.questionados.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.questionados.dto.CategoriaDto;
import com.mc.questionados.entity.Categoria;
import com.mc.questionados.repository.CategoriaRepo;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepo categoriaRepo;
	
	public Categoria get(Long id) {
		Optional<Categoria> categoriaResult = categoriaRepo.findById(id);
		if(categoriaResult.isPresent())
			return categoriaResult.get();
		return null;
		
	}
	
	public Iterable<Categoria> get() {
		Iterable<Categoria> categoriasResult = categoriaRepo.findAll();
		return categoriasResult;
		
	}
	
	public Categoria create(CategoriaDto dto) {
		Categoria categoriaNueva = new Categoria();
		categoriaNueva.setDescripcion(dto.getDescripcion());
		categoriaNueva.setNombre(dto.getNombre());
		
		categoriaRepo.save(categoriaNueva);
		return categoriaNueva;
		
	} 
	
	public Categoria update(Long categoriaId, CategoriaDto dto) {
		Optional<Categoria> categoria = categoriaRepo.findById(categoriaId);
		if(categoria.isPresent()) {
			Categoria categoriaActualizacion = categoria.get();
			categoriaActualizacion.setDescripcion(dto.getDescripcion().isEmpty() || dto.getDescripcion() == null ? categoriaActualizacion.getDescripcion() : dto.getDescripcion());
			categoriaActualizacion.setNombre(dto.getNombre().isEmpty() || dto.getNombre() == null ? categoriaActualizacion.getNombre() : dto.getNombre());
			
			categoriaRepo.save(categoriaActualizacion);
			return categoriaActualizacion;
		}
		
		return null;
		
	}
	
	
	public void delete(long id) {
		if(this.existById(id)) {
			categoriaRepo.deleteById(id);
		}
	}
	
	public Boolean existById(Long id) {
		Categoria resultado = this.get(id);
		return resultado != null;
	}
	

}
