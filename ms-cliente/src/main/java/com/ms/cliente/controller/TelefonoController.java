package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenTelefonoDTO;
import com.ms.cliente.dto.GenTelefonoResponse;
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
@Api( value = "Microservicio de Telefonos")
public interface TelefonoController {

	/**
	 * Metodo que ratifica el telefono valido
	 * 
	 * @return RatificarDatosRequest
	 * @throws NotRatificationException
	 */
    @ApiOperation(value = "Ratificar datos telefonicos del cliente", notes = "Ratifica datos telefonicos del cliente!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> ratificaTelefono(RatificarDatosRequest dataRatificacion) throws NotRatificationException;

    /**
	 * Metodo que retorna listado de telefonos por persona y contrato
	 * 
	 * @return DemograficDataRequest
	 * @throws UserNotFoundException
	 */
    @ApiOperation(value = "Buscar Telefonos", notes = "Retorna listado de numeros telefonicos!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<GenTelefonoResponse>> buscarTelefonos(DemograficDataRequest genTelefonoRequest) throws UserNotFoundException;
    
    
    /**
	 * Metodo inserta un telefono asaociado a una persona
	 * 
	 * @return GenTelefonoDTO
	 * @throws InsertOrUpdateException
	 */
    @ApiOperation(value = "Insertar telefono", notes = "Ingresa otro numero telefonico asociado a un cliente!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> insertTelefono(GenTelefonoDTO genTelefono) throws InsertOrUpdateException;
	
}
