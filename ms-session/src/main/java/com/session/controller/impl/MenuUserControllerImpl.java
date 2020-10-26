package com.session.controller.impl;

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
import com.session.controller.MenuUserController;
import com.session.dto.ApplicationDTO;
import com.session.service.MenuService;
import com.session.service.SolpService;

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
		UserInfoDTO temp1 = solpService.getLanding(userToken.getToken());
        List<ApplicationDTO> listadoresult =  menuService.findMenuFromSolp(temp1.getAplicaciones());
		log.info("[menuLanding]::fin de metodo");
		return new ResponseEntity<>( listadoresult , HttpStatus.OK);
	}
}
