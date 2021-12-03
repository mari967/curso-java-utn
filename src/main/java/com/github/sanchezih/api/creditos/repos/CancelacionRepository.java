package com.github.sanchezih.api.creditos.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.sanchezih.api.creditos.entities.Cancelacion;

@Repository
public interface CancelacionRepository extends JpaRepository<Cancelacion, Integer> {

}
