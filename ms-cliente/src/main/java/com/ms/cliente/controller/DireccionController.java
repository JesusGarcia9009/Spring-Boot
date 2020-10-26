package com.ms.cliente.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.cliente.dto.GenDireccionesDTO;
import com.ms.cliente.dto.GenDireccionesResponse;
import com.ms.cliente.dto.RatificarDatosRequest;
import com.pdr.common.exception.InsertOrUpdateException;
import com.pdr.common.exception.NotRatificationException;
import com.pdr.common.exception.UserNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * Interfaz del controller
 * 
 * @author BS2
 */
@Api( value = "Microservicio de direccion")
public interface DireccionController {

	/**
	 * Metodo que retorna listado de direcciones por contrato
	 * 
	 * @return BigDecimal
	 * @throws UserNotFoundException
	 */
	@ApiOperation(value = "Buscar Direccion", notes = "Retorna las direcciones asociadas a un cliente!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<List<GenDireccionesResponse>> buscarDirecciones(@PathVariable(value = "numDocto") BigDecimal numDocto) throws UserNotFoundException;
	
	
	/**
	 * Metodo que ratifica el direccion valida
	 * 
	 * @return RatificarDatosRequest
	 * @throws NotRatificationException
	 */
    @ApiOperation(value = "Ratificar datos del cliente", notes = "Ratifica datos del cliente segun tipo de ratificacion!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> ratificaDireccion(RatificarDatosRequest dataRatificacion) throws NotRatificationException;
    
    /**
	 * Metodo que inserta el direccion valida asaociada a una persona
	 * 
	 * @return GenDireccionesDTO
	 * @throws InsertOrUpdateException
	 */
    @ApiOperation(value = "Insertar direccion del cliente", notes = "Ingresa nuevos datos de direccion!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> insertarDireccion(GenDireccionesDTO genDireccion) throws InsertOrUpdateException;

	
}
