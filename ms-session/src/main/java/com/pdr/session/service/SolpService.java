package com.pdr.session.service;

import com.pdr.common.dto.solp.UserInfoDTO;
import com.pdr.common.exception.UserNotAuthException;
import com.pdr.session.dto.UserAuthRequestDTO;


/**
 * @author BS2
 */
public interface SolpService {

	
	/**
	 * Obtiene los datos del solp
	 * 
	 * @param dto
	 * @return
	 */
	public UserInfoDTO getSolp (UserAuthRequestDTO request) throws UserNotAuthException; 
}
