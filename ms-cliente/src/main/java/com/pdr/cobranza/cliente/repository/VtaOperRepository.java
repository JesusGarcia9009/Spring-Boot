package com.pdr.cobranza.cliente.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.VtaOperModel;

/**
 * @description The Interface VtaOperRepository.
 * @author BS2
 */
@Repository
public interface VtaOperRepository extends JpaRepository<VtaOperModel, BigDecimal> {
    
}

