package com.github.sanchezih.api.creditos.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.api.creditos.entities.Prestamo;

@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {
}
