package com.pdr.session.service;

import com.pdr.common.exception.UserNotAuthException;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;

/**
 * UserTemplateService
 * 
 * clase encargada de llamar los servicios de autentificacion de parque del recuerdo
 * 
 * @author nalva
 *
 */
public interface UserTemplateService  {

	/**
	 * Metodo que llama la autentificacion de paque y se trae la informacion necesaria para la manipulacio de datos
	 * 
	 * @param user
	 * @return
	 */
	UserAuthResponseDTO getUserParque(UserAuthRequestDTO user) throws UserNotAuthException;
	
}
