package com.session.service;

import com.session.entities.UsuarioModel;


/**
 * @author BS2
 */
public interface UsersService {

	
	/**
	 * Obtiene el Dto de lo usuarios
	 * 
	 * @param dto
	 * @return
	 */
	public UsuarioModel buscarUsers(Long id); 
	
	/**
	 * Obtiene el el modelo by username o rut
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public UsuarioModel buscarUserByNameOrRut(String userNameOrRut); 
	
	/**
	 * Cuenta que exista el usuario por rut o urname
	 * 
	 * @param string userNameOrRut
	 * @return model @see UsersModel
	 */
	public Long countUserByNameOrRut(String userNameOrRut) ;
}
