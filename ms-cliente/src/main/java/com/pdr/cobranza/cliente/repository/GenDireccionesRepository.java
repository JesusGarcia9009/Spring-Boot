package com.pdr.cobranza.cliente.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdr.cobranza.cliente.dto.GenDireccionesResponse;
import com.pdr.common.cobranza.entity.GenDireccionesModel;

/**
 * @description The Interface GenDireccionesRepository.
 * @author BS2
 */
@Repository
public interface GenDireccionesRepository extends JpaRepository<GenDireccionesModel, BigDecimal> {
	
	@Query(" select dir "
		 + " from GenDireccionesModel dir inner join dir.genComunas "
    	 + " where dir.numDocto = :numDocto order by dir.direFecMod desc")
	List<GenDireccionesModel> buscarDireccion(@Param("numDocto") BigDecimal numDocto);
	
	@Query(" select dir "
			 + " from GenDireccionesModel dir inner join dir.genComunas "
	    	 + " where dir.numDocto = :numDocto and dir.genComunas.comuCod = :comuCod and dir.genPersonas.id.persId = :persId "
	    	 + " and dir.direUserMod = :direUserMod and dir.direCalle = :direCalle and dir.direNumero = :direNumero")
	List<GenDireccionesModel> buscarDireccionXParam(@Param("numDocto") BigDecimal numDocto
			, @Param("comuCod") String comuCod
			, @Param("persId") String persId
			, @Param("direUserMod") String direUserMod
			, @Param("direCalle") String direCalle
			, @Param("direNumero") String direNumero);
	
    
	@Query(value = "SELECT * FROM GEN_DIRECCIONES " + 
			"			  WHERE PERS_ID = :persid  ORDER BY DIRE_FEC_MOD DESC" , nativeQuery = true)
		List<GenDireccionesModel> buscarDirecciones(@Param("persid") String persid);
	
	@Query(" select  new com.pdr.cobranza.cliente.dto.GenDireccionesResponse(dir.direSec, dir.direTipo, dir.direCalle, dir.direNumero,  " + 
																			" dir.direRestoDire, dir.direCodPostal, dir.direNac, dir.direPais,  " + 
																			" dir.direEstaCod, dir.direIndVerif, dir.direFecVerif, dir.soscSec,  " + 
																			" dir.contNumOpe, dir.reinSec, dir.direUserMod, dir.direFecMod,  " + 
																			" dir.tipoDocto, dir.numDocto, dir.direIndEnvCorr, dir.genComunas.comuDesc)  "
			 + " from GenDireccionesModel dir "
	    	 + " where dir.genPersonas.id.persId = :persId and dir.numDocto = :numDocto order by dir.direFecMod desc")
	List<GenDireccionesResponse> buscarDireccionesXPersId(@Param("persId") String persId, @Param("numDocto") BigDecimal numDocto);
	
}

