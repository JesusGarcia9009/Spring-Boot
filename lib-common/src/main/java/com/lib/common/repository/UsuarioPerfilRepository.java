package com.lib.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.common.entity.UsuarioPerfilModel;

/**
 * @description The Interface UsuarioPerfilRepository.
 * @author UsuarioPerfilRepository
 */
@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfilModel, Long> {
    

	
}