package com.mc.questionados.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mc.questionados.entity.Categoria;

@Repository
public interface CategoriaRepo extends CrudRepository<Categoria, Long> {
		
}
