package com.session.service;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.session.exception.UserNotAuthException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 * @since Java 1.8
 */
@Service
@Slf4j
public class RestTemplateServiceImpl implements RestTemplateService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	private Map<String, String> stringHeaders = new HashMap<String, String>();

	public <T, R> List<T> postRestList(Class<T> clase, String url, R request) throws Exception {
		HttpEntity<R> httpEntity = new HttpEntity<>(request, setHeaders());
		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, clase);
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.postForEntity(url, httpEntity, String.class);
		} catch (RestClientResponseException e) {
			if (e.getRawStatusCode() == HttpStatus.BAD_REQUEST.value()) {
				throw new UserNotAuthException("Usuario o clave incorrecto");
			}
			if (e.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new UserNotAuthException("Error al interno en el servicion Solp");
			}
			if (e.getRawStatusCode() == HttpStatus.NO_CONTENT.value()
					|| e.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
				throw new UserNotAuthException("Usuario no encontrado");
			}
			if (e.getRootCause() instanceof SocketTimeoutException) {
				throw new UserNotAuthException("Tiempo excedido en el servicio Solp.");
			}

		}
		return getObjectRest(response, collectionType);
	}

	public <T> List<T> getRestTokenList(Class<T> clase, String url, String token) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization","Bearer " + token);
		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, clase);
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

		return getObjectRest(response, collectionType);
	}

	public HttpHeaders setHeaders() throws Exception {
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.APPLICATION_JSON);
		stringHeaders.put("Accept", "application/json");
		for (Map.Entry<String, String> stringHeader : stringHeaders.entrySet()) {
			httpHeader.set(stringHeader.getKey(), stringHeader.getValue());
		}
		return httpHeader;
	}

	public HttpHeaders getRequestHeaderBearer(String token) {

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", token);

		return headers;

	}

	private <T> T getObjectRest(ResponseEntity<String> response, JavaType javaType) {
		T result = null;
		if (response.getStatusCode() == HttpStatus.OK || response.getStatusCode() == HttpStatus.CREATED) {
			try {
				objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
				objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
				result = objectMapper.readValue(response.getBody(), javaType);
			} catch (IOException ioe) {
				log.error("No es posible transformar respuesta rest a objeto: " + ioe);
			}
		} else {
			log.error("Error response codigo " + response.getStatusCode());
		}
		return result;
	}

}