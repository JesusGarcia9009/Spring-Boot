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
public class ApplicationDTO {
	
	private BigDecimal idApplication;
	
	private String name;
	
	private String description;
	
	private String imagen;
	
	private String color;
	
	private String url;
	
	private boolean isExterno;
	
	private boolean landingEnable;
	
	private List<ItemDTO> navItems = new ArrayList<>();

	public ApplicationDTO(BigDecimal idApplication, String name, String description, String imagen, String color, String url,
			Boolean isExterno , Boolean landingEnable, List<ItemDTO> navItems) {
		super();
		this.idApplication = idApplication;
		this.name = name;
		this.description = description;
		this.imagen = imagen;
		this.color = color;
		this.url = url;
		this.isExterno = isExterno;
		this.landingEnable = landingEnable;
		this.navItems = navItems;
	}

	
	
}
