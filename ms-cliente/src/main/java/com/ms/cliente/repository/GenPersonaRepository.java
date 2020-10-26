package com.ms.cliente.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ms.cliente.dto.V360ClienteResponseDTO;
import com.pdr.common.cobranza.entity.GenPersonasIdModel;
import com.pdr.common.cobranza.entity.GenPersonasModel;

/**
 * @description The Interface GenPersonaRepository.
 * @author BS2
 */
@Repository
public interface GenPersonaRepository extends JpaRepository<GenPersonasModel, GenPersonasIdModel> {
    

	@Query(value = "SELECT GENPAR.GEN_PERSONAS.* FROM GENPAR.GEN_PERSONAS WHERE GENPAR.GEN_PERSONAS.PERS_ID = :persId ", nativeQuery = true)
	GenPersonasModel findByPersId(@Param("persId") String persId);
	
	@Query(value = "SELECT new com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO ( "  + 
			" gp.id.persTipoId, gp.id.persId, gp.persDigVer ,gp.persApePat ,gp.persApeMat, gp.persNombres ,gp.persRazonSocial, gp.persNomFantasia, gp.persNivelEduc, "  + 
			" gp.persFecNac, gp.persFecDefun ,gp.persEdadDefun, gp.persEstCivil, gp.persNaci, gp.persSexo, gp.persTipo, gp.persGiro, gp.persUserMod, "  + 
			" gp.persFecMod) FROM GenPersonasModel gp INNER JOIN gp.vtaContratoses vc WHERE vc.doctoFolio = :doctoFolio and vc.serieCod= :serieCod ") 
	V360ClienteResponseDTO buscarClientesFolio(@Param("serieCod") String serieCod, @Param("doctoFolio") BigDecimal doctoFolio);
	

	@Query(value = "SELECT new com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO ( "  + 
			" gp.id.persTipoId, gp.id.persId, gp.persDigVer ,gp.persApePat ,gp.persApeMat, gp.persNombres ,gp.persRazonSocial, gp.persNomFantasia, gp.persNivelEduc, "  + 
			" gp.persFecNac, gp.persFecDefun ,gp.persEdadDefun, gp.persEstCivil, gp.persNaci, gp.persSexo, gp.persTipo, gp.persGiro, gp.persUserMod, "  + 
			" gp.persFecMod) FROM GenPersonasModel gp WHERE gp.id.persId = :PERS_ID   ") 
	List<V360ClienteResponseDTO> buscarClientesPersID(@Param("PERS_ID") String persId);
	
	@Query(value = "SELECT new com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO ( "  + 
			" gp.id.persTipoId, gp.id.persId, gp.persDigVer ,gp.persApePat ,gp.persApeMat, gp.persNombres ,gp.persRazonSocial, gp.persNomFantasia, gp.persNivelEduc, "  + 
			" gp.persFecNac, gp.persFecDefun ,gp.persEdadDefun, gp.persEstCivil, gp.persNaci, gp.persSexo, gp.persTipo, gp.persGiro, gp.persUserMod, "  + 
			" gp.persFecMod) FROM GenPersonasModel gp "
			+ " WHERE ("
			+ " (  LOWER(gp.persApePat || '' ||  gp.persApeMat || ' ' || gp.persNombres  ) LIKE  :NOMBRE   ) "
			+ " OR (LOWER(gp.persRazonSocial) LIKE :NOMBRE) "
			+ " OR (LOWER(gp.id.persId) LIKE :NOMBRE)  "
			+ ") and ROWNUM <= 30 ") 
	List<V360ClienteResponseDTO> buscarClientesNombre(@Param("NOMBRE") String nombre);
	
	
	@Query(value = "SELECT new com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO ( "  + 
			" gp.id.persTipoId, gp.id.persId, gp.persDigVer ,gp.persApePat ,gp.persApeMat, gp.persNombres ,gp.persRazonSocial, gp.persNomFantasia, gp.persNivelEduc, "  + 
			" gp.persFecNac, gp.persFecDefun ,gp.persEdadDefun, gp.persEstCivil, gp.persNaci, gp.persSexo, gp.persTipo, gp.persGiro, gp.persUserMod, "  + 
			" gp.persFecMod) FROM GenPersonasModel gp "
			+ " WHERE ("
			+ " (  LOWER(gp.persApePat || '' ||  gp.persApeMat || ' ' || gp.persNombres  ) LIKE  :NOMBRE AND LOWER(gp.persApePat || '' ||  gp.persApeMat || ' ' || gp.persNombres  ) LIKE  :APELLIDO   )   "
			+ " OR (LOWER(gp.persRazonSocial) LIKE :NOMBRE  AND  LOWER(gp.persRazonSocial) LIKE :APELLIDO ) "
			+ " OR (LOWER(gp.id.persId) LIKE :NOMBRE AND LOWER(gp.id.persId) LIKE :APELLIDO)  "
			+ ") and ROWNUM <= 30  ") 
	List<V360ClienteResponseDTO> buscarClientesNombre(@Param("NOMBRE") String nombre, @Param("APELLIDO") String apellido);
	
	
	
}
