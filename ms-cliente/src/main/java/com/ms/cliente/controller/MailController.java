package com.ms.cliente.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ms.cliente.dto.DemograficDataRequest;
import com.ms.cliente.dto.GenMailDTO;
import com.ms.cliente.dto.RatificarMailRequest;
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
@Api( value = "Microservicio de Mails")
public interface MailController {

	/**
	 * Metodo que ratifica el telefono mail valido, ademas de esto actualiza el mail de la persona
	 * 
	 * @return RatificarMailRequest
	 * @throws NotRatificationException
	 */
    @ApiOperation(value = "Ratificar datos de direcciones de mail", notes = "Ratifica direcion de mail del cliente!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<Boolean> ratificaMail(RatificarMailRequest dataRatificacion) throws NotRatificationException;
    
    
    /**
	 * Metodo que retorna listado de direcciones de mail por persona y contrato
	 * 
	 * @return DemograficDataRequest
	 * @throws UserNotFoundException
	 */
    @ApiOperation(value = "Buscar Mail", notes = "Retorna las direcciones de mail!")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Retorno satisfactorio")})
    public ResponseEntity<List<GenMailDTO>> buscarMails(DemograficDataRequest genMailRequest) throws UserNotFoundException;

	
}
