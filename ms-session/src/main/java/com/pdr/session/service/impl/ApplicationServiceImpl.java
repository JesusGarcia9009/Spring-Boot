package com.pdr.session.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdr.common.session.entity.ApplicationModel;
import com.pdr.session.dto.MenuLandingResponseDTO;
import com.pdr.session.repository.ApplicationRepository;
import com.pdr.session.service.ApplicationService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ApplicationServiceImpl implements ApplicationService{

	@Autowired
	private ApplicationRepository applicationRepository;
	
	public List<MenuLandingResponseDTO> getMenuLanding(){
		log.info("[getMenuLanding] inicio del metodo que tra el menu landing");
		List<MenuLandingResponseDTO> response = new ArrayList<MenuLandingResponseDTO>();
	
		List<ApplicationModel> model = applicationRepository.findAll();
		
		for(ApplicationModel app : model) {
			MenuLandingResponseDTO dto = new MenuLandingResponseDTO();
			dto.setIcon("por definir");
			dto.setColor("por definir");
			dto.setIsLandingEnable(app.getLandingPage().equals("1") ? true : false );
			dto.setIdApplication(app.getIdApplication().longValue());
			dto.setName(app.getName());
			dto.setDescription(app.getDescription());
			
			response.add(dto);
		}
		log.info("[getMenuLanding] fin del metodo que tra el menu landing");
		return  response;
				
		
	}
	
	
}
