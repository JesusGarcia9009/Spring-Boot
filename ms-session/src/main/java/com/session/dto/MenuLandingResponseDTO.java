package com.session.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MenuLandingResponseDTO {
	
	private Long idApplication;
	private String name;
	private String description;
	private String icon;
	private String color;
	private Boolean isLandingEnable;

}
