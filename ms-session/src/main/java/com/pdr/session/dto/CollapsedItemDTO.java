package com.pdr.session.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Setter
@Getter
@ToString
public class CollapsedItemDTO {
	
	private String title;
	
	private String url;
	
	private boolean active;
	
	public CollapsedItemDTO() {
		super();
	}
	
	public CollapsedItemDTO(String title, String url, boolean active) {
		super();
		this.title = title;
		this.url = url;
		this.active = active;
	}
	
	

}
