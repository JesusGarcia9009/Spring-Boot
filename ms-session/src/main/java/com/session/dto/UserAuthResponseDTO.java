package com.session.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserAuthResponseDTO {
	
	private Long id;
	private String username;
	private String fullName;
	private String token;

}
