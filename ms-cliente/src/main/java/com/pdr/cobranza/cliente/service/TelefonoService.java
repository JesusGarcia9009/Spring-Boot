package com.pdr.cobranza.cliente.service;

import java.util.List;

import com.pdr.cobranza.cliente.dto.DemograficDataRequest;
import com.pdr.cobranza.cliente.dto.GenTelefonoDTO;
import com.pdr.cobranza.cliente.dto.GenTelefonoResponse;
import com.pdr.cobranza.cliente.dto.RatificarDatosRequest;
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
