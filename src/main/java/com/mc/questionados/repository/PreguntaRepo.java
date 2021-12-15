package com.mc.questionados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mc.questionados.entity.Pregunta;

@Repository
public interface PreguntaRepo extends CrudRepository<Pregunta, Long> {

	Pregunta findByEnunciado(String enunciado);
	
	@Query(value = "SELECT p FROM Pregunta p WHERE p.categoria.categoria_id = ?1")
	List<Pregunta> findByCategoriaId(Long categoriaId);
	
}
