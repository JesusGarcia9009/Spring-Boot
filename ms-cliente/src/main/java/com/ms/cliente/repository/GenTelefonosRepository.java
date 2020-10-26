package com.ms.cliente.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.GenTelefonosModel;

/**
 * @description The Interface GenTelefonosRepository.
 * @author BS2
 */
@Repository
public interface GenTelefonosRepository extends JpaRepository<GenTelefonosModel, BigDecimal> {
	
	@Query(value = "SELECT * FROM GEN_TELEFONOS WHERE PERS_ID = :persId and NUM_DOCTO = :numDocto order by FONO_FEC_MOD desc", nativeQuery = true)
	List<GenTelefonosModel> buscarTelefonos(String persId, BigDecimal numDocto);
	
	@Query(" select fono "
			 + " from GenTelefonosModel fono "
	    	 + " where fono.numDocto = :numDocto and fono.genPersonas.id.persId = :persId "
	    	 + " and fono.fonoUserMod = :fonoUserMod and fono.fonoNumero = :fonoNumero")
	List<GenTelefonosModel> buscarTelefonoXParam(@Param("numDocto") BigDecimal numDocto
			, @Param("persId") String persId
			, @Param("fonoUserMod") String fonoUserMod
			, @Param("fonoNumero") String fonoNumero);
	
	
	@Query(value = "SELECT TRUNC(SYSDATE) - TRUNC(FONO_FEC_MOD) DIF " + 
			" FROM GEN_TELEFONOS WHERE PERS_ID= :persId " + 
			"  ORDER BY FONO_FEC_MOD DESC ", nativeQuery = true)
	List<Object> datosClienteDesactualizado(@Param("persId") String persId);
	
	
	@Query(value = "SELECT * FROM (SELECT  * FROM gen_telefonos WHERE PERS_ID = :persId AND FONO_NUMERO LIKE  '2%'  ORDER BY FONO_FEC_MOD DESC) WHERE rownum <=1 " + 
			"       UNION ALL " + 
			"       SELECT * FROM (SELECT  * FROM gen_telefonos WHERE PERS_ID = :persId AND FONO_NUMERO LIKE  '9%'  ORDER BY FONO_FEC_MOD DESC) WHERE rownum <=2", nativeQuery = true)
	List<GenTelefonosModel> getTelefonosCliente(@Param("persId") String persId);
	
}

