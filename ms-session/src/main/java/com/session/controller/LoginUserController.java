package com.session.controller;

import org.springframework.http.ResponseEntity;

import com.session.dto.UserAuthRequestDTO;
import com.session.dto.UserAuthResponseDTO;
import com.session.exception.UserNotAuthException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


/**
 * LoginUserController
 * 
 * @author LoginUserController
 */
@Api(value = "Microservicio de Login", description = "Esta API tiene los servicios referentes a operaciones de autentificacion")
public interface LoginUserController {


	/**
	 * Metodo encargado de llamar la autentificacion de parque y asignar los roles al token creado.
	 * 
	 * @param dto UserAuthRequestDTO.class 
	 * @return
	 */
	@ApiOperation(value = "Autentificar", notes = "Retorna los datos de la api de coneccion a nuestra aplicacion")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorno satisfactorio")})
	public ResponseEntity<UserAuthResponseDTO> autenticacionUsuario(UserAuthRequestDTO dto)throws UserNotAuthException ;
	
	
	
}
