package com.pdr.cobranza.cliente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;
import com.pdr.common.cobranza.entity.GenComunasModel;
import com.pdr.common.cobranza.entity.GenRegionesModel;

/**
 * @description The Interface GenComunasRepository.
 * @author BS2
 */
@Repository
public interface GenComunasRepository extends JpaRepository<GenComunasModel, String> {
	
	List<GenComunasModel> findByGenRegiones(GenRegionesModel genRegiones);
	
	@Query(" select com "
			 + " from GenComunasModel com inner join com.genRegiones reg"
	    	 + " where reg.regiCod = :regiCod ")
	List<GenComunasModel> findByRegion(@Param("regiCod") Integer regiCod);
	
	@Query(" select  new com.pdr.cobranza.cliente.dto.GenComunasResponseDTO(com.comuCod , com.ciudCod, com.comuDesc, reg.regiCod)  "
			 + " from GenComunasModel com inner join com.genRegiones reg"
	    	 + " where reg.regiCod = :regiCod ")
	List<GenComunasResponseDTO> findByRegionCustom(@Param("regiCod") Integer regiCod);
	
	@Query(" select  new com.pdr.cobranza.cliente.dto.GenComunasResponseDTO(com.comuCod , com.ciudCod, com.comuDesc, reg.regiCod)  "
			 + " from GenComunasModel com inner join com.genRegiones reg")
	List<GenComunasResponseDTO> findAllCustom();
	
	@Query(" select com "
			 + " from GenComunasModel com "
	    	 + " where com.comuCod = :comuCod ")
	GenComunasModel findByCod(@Param("comuCod") String comuCod);
	
}

