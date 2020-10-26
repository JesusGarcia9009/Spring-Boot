package com.pdr.common.cobranza.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.GenValConvMondIdModel;
import com.pdr.common.cobranza.entity.GenValConvMondModel;

/**
 * @description The Interface CobPagareRepository.
 * @author BS2
 */
@Repository
public interface GenValConvMondUtilRepository extends JpaRepository<GenValConvMondModel, GenValConvMondIdModel> {
    
	@Query(" select com.comoValor "
			 + " from GenValConvMondModel com "
	    	 + " where com.id.moneCod = 'UF' and  TO_CHAR(com.id.comoFech, 'yyyy-mm-dd') = :fecha")
	BigDecimal obtenerValorUfByFecha(@Param("fecha") String fecha);
	
}