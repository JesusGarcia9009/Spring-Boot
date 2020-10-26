package com.pdr.cobranza.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.CbzTipoDireccionModel;

@Repository
public interface CbzTipoDireccionRepository extends JpaRepository<CbzTipoDireccionModel, Long> {

}
