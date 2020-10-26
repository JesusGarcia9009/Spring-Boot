package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.GenRegionesResponseDTO;

/**
 * Servicio encargado de traer la informacion de la base de datos de pdr de regiones
 * 
 * @author NelsonAlvaradoVidal
 *
 */
public interface GenRegionesService {
	
	
	/**
	 * Metodo encargado de entregar la informacion de la tabla de regiones de pdr
	 * 
	 * @return List<GenRegionesResponseDTO> 
	 */
	List<GenRegionesResponseDTO> getRegiones();
}
