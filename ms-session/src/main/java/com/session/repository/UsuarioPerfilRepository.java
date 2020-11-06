package com.session.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.session.entities.UsuarioPerfilModel;


/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfilModel, Long> {

}
