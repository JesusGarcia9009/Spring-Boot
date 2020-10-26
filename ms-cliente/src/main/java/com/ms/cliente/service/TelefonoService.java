package com.ms.cliente.service;

import java.util.List;

import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenTelefonoDTO;
import com.ms.cliente.dto.GenTelefonoResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.pdr.common.exception.InsertOrUpdateException;

/**
 * @author BS2
 */
public interface TelefonoService {

	/**
	 * Ratificar informacion telefonica
	 */
	public boolean ratificarTelefono(RatificarDatosRequest dataRatificacion);
	
	/**
	 * Buscar listado de Telefonos
	 */
	public List<GenTelefonoResponse> buscarTelefonos(DemograficDataRequest genTelefonoRequest);
	
	/**
	 * Ingresa o actualiza datos de telefono
	 */
	public boolean insertTelefono(GenTelefonoDTO genTelefono) throws InsertOrUpdateException;
}
