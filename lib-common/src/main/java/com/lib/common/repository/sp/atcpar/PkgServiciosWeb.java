package com.lib.common.repository.sp.atcpar;

import java.util.Map;

import com.lib.common.dto.PersonaDTO;

/**
 * 
 * 
 * @author NelsonAlvaradoVidal
 *
 */
public interface PkgServiciosWeb {
	
	/**
	 * 
	 * @param persona
	 */
	public Map<String, Object> getlstcontrol(PersonaDTO dto); 

}
