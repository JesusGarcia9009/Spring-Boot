package com.lib.common.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lib.common.entity.CbzPropiedadesModel;

public interface CbzPropiedadesCommonRepository extends JpaRepository<CbzPropiedadesModel, Integer> {
	
	Optional<CbzPropiedadesModel> findByCpPropKey(String key);
	
	@Query(value = " select sysdate  from dual " , nativeQuery = true)
	Date getDate(); 

}
