/**
 * 
 */
package com.pdr.session.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pdr.common.dto.solp.AplicacionSolpDTO;
import com.pdr.session.dto.ApplicationDTO;

/**
 * @author BS2
 *
 */
@Service
public interface MenuService {
	
	/**
	 * Obtiene el listado de los menus a cargar
	 * 
	 * @param listado de perfiles
	 * @return
	 */
	public List<ApplicationDTO> findMenu(List<Long> profileList); 
	
	
	/**
	 * Obtiene el listado de los menus a cargar pero consultando el servicio de Solp
	 * 
	 * @param listado de AplicacionSolpDTO 
	 * @return List<ApplicationDTO>
	 */
	public List<ApplicationDTO> findMenuFromSolp(List<AplicacionSolpDTO> listadoAppSolp);
	
	

}
