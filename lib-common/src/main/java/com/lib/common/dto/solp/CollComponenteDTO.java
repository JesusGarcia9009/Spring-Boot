package com.lib.common.dto.solp;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author BS2
 */
public class CollComponenteDTO {
	
	@JsonProperty
	@JsonAlias("HEADER")
	private String header;
	
	@JsonProperty
	@JsonAlias("COLLAPSEDITEMS")
	private List<CollElementoDTO> collapsedItem = new ArrayList<>();

	public CollComponenteDTO() {
		super();
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<CollElementoDTO> getCollapsedItem() {
		return collapsedItem;
	}

	public void setCollapsedItem(List<CollElementoDTO> collapsedItem) {
		this.collapsedItem = collapsedItem;
	}


	
}
