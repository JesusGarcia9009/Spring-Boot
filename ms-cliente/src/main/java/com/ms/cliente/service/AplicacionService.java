package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.AplicacionesDTO;

/**
 * @author BS2
 *
 */
public interface AplicacionService {

	/**
	 * Busca la informacion de las aplicaciones del sistema
	 * 
	 * @param -----
	 * @return List<AplicacionesDTO>
	 */
	public List<AplicacionesDTO> obtenerAplicaciones();
	
	

}
