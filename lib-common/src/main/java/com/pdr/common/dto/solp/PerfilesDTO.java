package com.pdr.common.dto.solp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */
public class PerfilesDTO {
	
	@JsonProperty
	@JsonAlias("ID_PROFILE")
	private Integer idProfile;
	
	@JsonProperty
	@JsonAlias("NAME")
	private String name;

	public PerfilesDTO() {
		super();
	}

	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	

	
}
