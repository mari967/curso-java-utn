package com.mc.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mc.questionados.entity.Categoria;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria, Long> {
		
}
