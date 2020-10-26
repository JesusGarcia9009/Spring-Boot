package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.CbzTipoDocumentoResponseDTO;

/**
 * Metodo que se conecta a la bd y trae la informacion de las direcciones.
 * 
 * @author NelsonAlvaradoVidal
 *
 */
public interface TipoDireccionService {

	
	/**
	 * Obtiene la informacion de los tipo de documentos
	 *
	 * @return
	 */
    List<CbzTipoDocumentoResponseDTO> getTipoDireccion();
}