package com.mc.questionados.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mc.questionados.entity.Categoria;
import com.mc.questionados.entity.Pregunta;

@Repository
public interface PreguntaRepo extends CrudRepository<Pregunta, Long> {

}
