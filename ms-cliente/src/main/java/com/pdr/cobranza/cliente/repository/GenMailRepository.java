package com.pdr.cobranza.cliente.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdr.common.cobranza.entity.GenMailIdModel;
import com.pdr.common.cobranza.entity.GenMailModel;

/**
 * @description The Interface GenMailRepository.
 * @author BS2
 */
@Repository
public interface GenMailRepository extends JpaRepository<GenMailModel, GenMailIdModel> {
    
	@Query(value = "SELECT * FROM GEN_MAIL WHERE  PERS_ID = :persId and NUM_DOCTO= :numDocto ORDER BY MAIL_FEC_MOD DESC", nativeQuery = true)
	List<GenMailModel> buscarMails(String persId, BigDecimal numDocto);
	
	@Query(value = "SELECT * FROM GEN_MAIL WHERE pers_id = :persId ORDER BY MAIL_FEC_MOD desc ", nativeQuery = true)
	List<GenMailModel> buscarMails(String persId);
	
}

