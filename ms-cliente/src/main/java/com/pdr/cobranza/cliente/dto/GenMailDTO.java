/**
 * 
 */
package com.pdr.cobranza.cliente.dto;

import java.util.Date;

import com.pdr.common.cobranza.entity.GenMailIdModel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author BS2
 */
@Getter
@Setter
@ToString
public class GenMailDTO {

	private GenMailIdModel id; 

	private String mailEmail;
	
	private String mailUserMod;
	
	private Date mailFecMod;
}
