package com.session.service;

import java.util.List;

/**
 * Interface para el servicios Rest
 * @author BS2
 */
public interface RestTemplateService {

	public <T, R> List<T> postRestList(Class<T> clase, String url, R request) throws Exception ;
	
	public <T> List<T> getRestTokenList(Class<T> clase, String url, String token) throws Exception;
	
	

}
