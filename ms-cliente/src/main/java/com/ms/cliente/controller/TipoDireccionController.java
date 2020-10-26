package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.cliente.dto.CbzTipoDocumentoResponseDTO;
import com.pdr.common.exception.DataNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Microservicio CRUD
 * 
 * MS de listado de de los tipos de documento de direccion,correo y telfono
 * 
 * @author BS2
 */
@Api( value = "Microservicio de tipo de direccion")
public interface TipoDireccionController {
	
	
	/**
	 * Metodo que nos trae los tipo de documentos
	 * 
	 * @return List<CbzTipoDocumentoResponseDTO>
	 * @throws DataNotFoundException
	 */
	@ApiOperation(value = "Buscar tipo documentos", notes = "Retorna la persona solicitada a partir de los datos!")
	@ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<CbzTipoDocumentoResponseDTO>>  obtenerTipoDireccion() throws DataNotFoundException;


}
