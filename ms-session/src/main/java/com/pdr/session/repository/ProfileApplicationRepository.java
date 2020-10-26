package com.pdr.session.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pdr.common.session.entity.ProfileApplicationModel;


/**
 * @description The Interface ProfileApplicationRepository.
 * @author BS2
 */
@Repository
public interface ProfileApplicationRepository extends JpaRepository<ProfileApplicationModel, BigDecimal> {

	
	@Query(value = "SELECT unique a.ID_APPLICATION AS idApplication , a.NAME AS NameApp , SUBAPP.ID_SUB_MENU_APPLICATION AS idSubMenuApp, SUBAPP.NAME AS nameSubMenuApp, " + 
					"	   SUBAPP.VALID AS validSubMenuApp, SUBMENU.ID_SUB_MENU_FUNCION AS idSubMenuFunc , SUBMENU.NAME AS nameSubMenuFunc, SUBMENU.URL AS urlSubMenuFunc, " + 
					"	   SUBMENU.VALID AS validSubMenuFunc " + 
					"FROM  extpar.profile p " + 
					"INNER JOIN extpar.profile_application pa on pa.id_profile  = p.id_profile " + 
					"INNER JOIN extpar.APPLICATION a on a.ID_APPLICATION = pa.ID_APPLICATION  " + 
					"INNER JOIN extpar.profile_sub_application app on app.id_profile_application = pa.id_profile_application " + 
					"INNER JOIN extpar.sub_menu_application subapp on subapp.id_sub_menu_application = app.id_sub_menu_application " + 
					"INNER JOIN extpar.sub_menu_funcion submenu on submenu.id_sub_menu_application = subapp.id_sub_menu_application  " + 
					"WHERE p.id_profile in (:profileList) ", nativeQuery = true)
	List<Object> findMenuByIdsProfile(List<Long> profileList);
}
