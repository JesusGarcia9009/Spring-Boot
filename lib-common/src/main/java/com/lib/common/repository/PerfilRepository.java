package com.lib.common.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.common.entity.PerfilModel;

public interface PerfilRepository extends JpaRepository<PerfilModel, Long> {
	
	Optional<PerfilModel> findByNombre(String nombre); 

}
