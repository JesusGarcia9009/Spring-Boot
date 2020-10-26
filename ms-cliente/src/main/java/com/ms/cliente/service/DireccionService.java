package com.ms.cliente.service;

import java.math.BigDecimal;
import java.util.List;

import com.ms.cliente.dto.GenDireccionesDTO;
import com.ms.cliente.dto.GenDireccionesResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.pdr.common.exception.InsertOrUpdateException;

/**
 * @author BS2
 */
public interface DireccionService {

	/**
	 * Ratificar informacion de direccion
	 */
	public boolean ratificarDireccion(RatificarDatosRequest dataRatificacion);
	
	/**
	 * Buscar listado de direcciones
	 */
	public List<GenDireccionesResponse> buscarDirecciones(BigDecimal numDocto);
	
	/**
	 * Ingresa datos de direccion
	 */
	public boolean insertDireccion(GenDireccionesDTO genDireccion) throws InsertOrUpdateException;
}
