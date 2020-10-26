package com.ms.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.VtaPgreOperContIdModel;
import com.pdr.common.cobranza.entity.VtaPgreOperContModel;

/**
 * @description The Interface VtaPgreOperContRepository.
 * @author BS2
 */
@Repository
public interface VtaPgreOperContRepository extends JpaRepository<VtaPgreOperContModel, VtaPgreOperContIdModel> {
    
}

