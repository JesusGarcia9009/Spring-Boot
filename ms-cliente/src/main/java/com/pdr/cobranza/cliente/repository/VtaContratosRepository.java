package com.pdr.cobranza.cliente.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.VtaContratosModel;

/**
 * @description The Interface VtaContratosRepository.
 * @author BS2
 */
@Repository
public interface VtaContratosRepository extends JpaRepository<VtaContratosModel, BigDecimal> {
    
}

