package com.pdr.common.dto.solp;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */


public class UserInfoDTO {

	@JsonProperty
	private String username;
	
	@JsonProperty
	private String token;
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String fullname;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	@JsonAlias("USERPROFILES")
	private List<PerfilesDTO> profiles = new ArrayList<>();
	
	@JsonProperty
	@JsonAlias("APLICACIONES")
	private List<AplicacionSolpDTO> aplicaciones = new ArrayList<>();


	public UserInfoDTO(String username, String token, Long id, String fullname, String email) {
		super();
		this.username = username;
		this.token = token;
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		
	}

	public UserInfoDTO() {
		super();
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<PerfilesDTO> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<PerfilesDTO> profiles) {
		this.profiles = profiles;
	}

	public List<AplicacionSolpDTO> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(List<AplicacionSolpDTO> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	
	
	
}
