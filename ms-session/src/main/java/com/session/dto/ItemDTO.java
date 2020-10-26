/**
 * 
 */
package com.session.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Setter
@Getter
@ToString
public class ItemDTO {
	
	private String icon;
	
	private BigDecimal id;
	
	private String dataTarget;
	
	private String title;
	
	private String url;
	
	private boolean active;
	
	private List<CollapsedComponentDTO> collapsedComponent = new ArrayList<>();
	
	public ItemDTO() {
		super();
	}

	public ItemDTO(String icon, BigDecimal id, String dataTarget, String title, String url, boolean active,
			List<CollapsedComponentDTO> collapsedComponent) {
		super();
		this.icon = icon;
		this.id = id;
		this.dataTarget = dataTarget;
		this.title = title;
		this.url = url;
		this.active = active;
		this.collapsedComponent = collapsedComponent;
	}
	
	

}
