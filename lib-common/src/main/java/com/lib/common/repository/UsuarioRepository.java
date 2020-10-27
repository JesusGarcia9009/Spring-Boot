package com.lib.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.common.entity.UsuarioModel;

/**
 * @description The Interface UsuarioRepository.
 * @author UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    
	
	
}