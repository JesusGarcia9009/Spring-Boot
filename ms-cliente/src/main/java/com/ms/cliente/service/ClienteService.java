package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.DatosClienteResponseDTO;
import com.ms.cliente.dto.GenPersonaIdRequest;
import com.ms.cliente.dto.GenPersonasDTO;
import com.ms.cliente.dto.V360ClienteRequestDTO;
import com.ms.cliente.dto.V360ClienteResponseDTO;

/**
 * @author BS2
 *
 */
public interface ClienteService {

	/**
	 * Busca la informacion de los clientes a traves de un tipo de documento
	 * 
	 * @param PersonaId
	 * @return
	 */
	public GenPersonasDTO buscarCliente(GenPersonaIdRequest personaId);
	
	/**
	 * Busca la informacion de los clientes a traves de un criterio
	 * 
	 * @param String 
	 * @return List<V360ClienteResponseDTO>
	 */
	public List<V360ClienteResponseDTO> getListCliente(String buscador);
	
	
	/**
	 * Busca la informacion de los clientes a traves de un criterio(folio)
	 * 
	 * @param String 
	 * @return List<V360ClienteResponseDTO>
	 */
	public V360ClienteResponseDTO getListClienteFolio(V360ClienteRequestDTO folio);

	
	
	/**
	 * Busca la info del cliente para verificar si los datos se encuentran desacatualizados
	 * 
	 * @param String 
	 * @return V360ClienteDesactulizadoRequestDTO
	 */
	boolean validaClienteDesactualizado(String desactualizado);
	
	
	
	/**
	 * Obtiene todos los datos del cliente
	 * 
	 * @param String 
	 * @return V360ClienteDesactulizadoRequestDTO
	 */
	DatosClienteResponseDTO datosCliente(String persid, String numDocto);

}
