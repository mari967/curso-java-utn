package com.github.sanchezih.api.creditos.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.api.creditos.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	Cliente findByClienteId(Integer id);

	boolean existsByNombre(String nombre);

	boolean existsByDni(int dni);
}
