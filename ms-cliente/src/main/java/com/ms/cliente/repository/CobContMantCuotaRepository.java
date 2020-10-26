/**
 * 
 */
package com.ms.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.CobContMantCuotaIdModel;
import com.pdr.common.cobranza.entity.CobContMantCuotaModel;

/**
 * @description The Interface CobContMantCuotaRepository.
 * @author BS2
 */
@Repository
public interface CobContMantCuotaRepository extends JpaRepository<CobContMantCuotaModel, CobContMantCuotaIdModel> {
    
}

