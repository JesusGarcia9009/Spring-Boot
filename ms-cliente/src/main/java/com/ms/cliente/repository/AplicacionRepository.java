package com.ms.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lib.common.entity.AplicacionModel;

/**
 * @description The Interface GenMailRepository.
 * @author BS2
 */
@Repository
public interface AplicacionRepository extends JpaRepository<AplicacionModel, Long> {
    

}

