package com.pdr.cobranza.cliente.controller.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ms.cliente.dto.GenMailDTO;
import com.pdr.common.cobranza.entity.GenMailIdModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MailMock {

	
	public static List<GenMailDTO> mockMail(){
		log.info("[mockMail]:: inicio del metodo");
		List<GenMailDTO> result = new ArrayList<GenMailDTO>();
		GenMailDTO dto = new GenMailDTO();
		dto.setId(new GenMailIdModel());
		dto.setMailEmail("nalvarado@bs2.cl");
		dto.setMailFecMod(new Date());
		dto.setMailUserMod("nalvarado");
		result.add(dto);
		log.info("[mockMail]:: fin del metodo");
		return result;
		
	}
}
