package com.pdr.session.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.common.dto.solp.UserInfoDTO;
import com.pdr.common.session.security.annotations.TokenUsuario;
import com.pdr.common.session.security.dto.UserPrincipal;
import com.pdr.session.controller.MenuUserController;
import com.pdr.session.dto.ApplicationDTO;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.service.MenuService;
import com.pdr.session.service.SolpService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@Slf4j
@RestController
@RequestMapping("${api.config.common.base.uri}/menu")
public class MenuUserControllerImpl implements MenuUserController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private SolpService solpService;
	
	@PostMapping("/landing-page")
	public ResponseEntity<List<ApplicationDTO>> menuLanding(@TokenUsuario UserPrincipal userToken) throws Exception {
		log.info("[menuLanding]::inicio de metodo");
		UserInfoDTO temp = solpService.getSolp(getUserAuthRequestDTO(userToken.getUserInput(), userToken.getTexto()));
		log.info("[menuLanding]::fin de metodo");
		return new ResponseEntity<>(menuService.findMenuFromSolp(temp.getAplicaciones()), HttpStatus.OK);
	}
	
	private UserAuthRequestDTO getUserAuthRequestDTO(String username , String password) {
		UserAuthRequestDTO request = new UserAuthRequestDTO();
		request.setPassword(password);
		request.setUsername(username);
		return request;
	}


}
