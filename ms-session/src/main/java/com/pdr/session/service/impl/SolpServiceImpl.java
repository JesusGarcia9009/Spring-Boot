/**
 * 
 */
package com.pdr.session.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pdr.common.dto.solp.UserInfoDTO;
import com.pdr.common.exception.UserNotAuthException;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.service.RestTemplateService;
import com.pdr.session.service.SolpService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@Service
@Slf4j
public class SolpServiceImpl implements SolpService {
	
	@Value("${api.losparques.endpoint.auth.solp}")
	private String urlSolp;

	@Autowired 
	private RestTemplateService restTemplateService;

	@Override
	public UserInfoDTO getSolp(UserAuthRequestDTO request) throws UserNotAuthException {
		log.info("[getSolp]::inicio de metodo");
		
		UserInfoDTO resultado = null;
		List<UserInfoDTO> response;
		try {
			response = restTemplateService.postRestList(UserInfoDTO.class, urlSolp, request);
		} catch (Exception e) {
			throw new UserNotAuthException(e.getMessage());
		}
		if(response != null && !response.isEmpty()) {
			resultado = response.get(0);
		}
		log.info("[getSolp]::inicio de metodo");
		return resultado;
	}
	
	
}
