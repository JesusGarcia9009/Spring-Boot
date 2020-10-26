package com.pdr.common.cobranza.repository.sp.atcpar;

import java.util.Map;

import com.pdr.common.dto.PersonaDTO;

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
