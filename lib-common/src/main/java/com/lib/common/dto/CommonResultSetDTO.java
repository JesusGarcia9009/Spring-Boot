package com.lib.common.dto;

import java.sql.ResultSet;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonResultSetDTO {
	
	private ResultSet result;
	private int rowNum;

}
