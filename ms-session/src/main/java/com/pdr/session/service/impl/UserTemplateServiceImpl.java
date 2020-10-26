package com.pdr.session.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pdr.common.exception.UserNotAuthException;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;
import com.pdr.session.service.UserTemplateService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserTemplateServiceImpl implements UserTemplateService {

	@Value("${api.losparques.endpoint.auth}")
	private String urlServicio;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserAuthResponseDTO getUserParque(UserAuthRequestDTO user) throws UserNotAuthException {
		log.info("[getUserParque]::llamamos servicio de parque del recuerdo.");
		log.info("[getUserParque]::url->" + this.urlServicio);
		try {
			ResponseEntity<UserAuthResponseDTO> response = null;
			HttpEntity<UserAuthRequestDTO> httpEntity = new HttpEntity<UserAuthRequestDTO>(user);
			response = restTemplate.exchange(urlServicio, HttpMethod.POST, httpEntity,
					new ParameterizedTypeReference<UserAuthResponseDTO>() {
					});
			return response.getBody();
		} catch (Exception e) {
			throw new UserNotAuthException("usuario no es posible de autenticar");
		}
	}

}
