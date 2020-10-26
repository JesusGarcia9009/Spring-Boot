package com.pdr.cobranza.cliente.repository.sp;

import java.util.List;
import java.util.Map;

import com.pdr.cobranza.cliente.dto.V360ClienteResponseDTO;




/**
 * Interfaz del repositorio que hace el llamado a una funcion de oracle
 * 
 * @author Patricio Martinez
 *
 */
public interface PrmGetLst360UbiperRepository {

	/**
	 * Funcion que obtiene todos los contratos activos de un cliente.
	 * 
	 * @param dto
	 * @return
	 */
	public Map<String, Object> getListClienteV360(String buscador); 
	

	public List<V360ClienteResponseDTO> getListClienteV360v2(String buscador); 
	
}
