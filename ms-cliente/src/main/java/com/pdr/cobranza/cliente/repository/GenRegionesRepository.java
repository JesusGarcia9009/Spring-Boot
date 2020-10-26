package com.pdr.cobranza.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdr.cobranza.cliente.dto.GenRegionesResponseDTO;
import com.pdr.common.cobranza.entity.GenRegionesModel;

/**
 * @description The Interface GenRegionesRepository.
 * @author BS2
 */
@Repository
public interface GenRegionesRepository extends JpaRepository<GenRegionesModel, Integer> {
    
	
	@Query(" select  new com.pdr.cobranza.cliente.dto.GenRegionesResponseDTO(reg.regiCod , reg.regiNumRoma, reg.regiDesc)  "
			 + " from GenRegionesModel reg ")
	List<GenRegionesResponseDTO> findAllCustom();
}

