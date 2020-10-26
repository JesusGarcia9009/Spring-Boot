/**
 * 
 */
package com.ms.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.CobContMantencionIdModel;
import com.pdr.common.cobranza.entity.CobContMantencionModel;

/**
 * @description The Interface CobContMantencionRepository.
 * @author BS2
 */
@Repository
public interface CobContMantencionRepository extends JpaRepository<CobContMantencionModel, CobContMantencionIdModel> {
    
}