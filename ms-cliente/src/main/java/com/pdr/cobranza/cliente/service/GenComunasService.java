package com.pdr.cobranza.cliente.service;

import java.util.List;

import com.pdr.cobranza.cliente.dto.GenComunasResponseDTO;


/**
 * Clase encargada de connectar con la base de datos de pdr y traer informacion de la tabla de comunas
 * 
 * 
 * @author NelsonAlvaradoVidal
 *
 */
public interface GenComunasService {

	/**
	 * Metodo encargado de extraer la informacion de la comuna a trave de un atributo
	 * 
	 * @param idRegion id de la region.
	 * @return
	 */
	List<GenComunasResponseDTO> getComuna(Integer idRegion);
	

}
