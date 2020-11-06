package com.session.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.session.dto.UserAuthRequestDTO;
import com.session.dto.UserAuthResponseDTO;
import com.session.dto.UserPrincipal;
import com.session.exception.UserNotAuthException;
import com.session.utils.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginUserControllerImpl implements LoginUserController {

	@Autowired
	public JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/auth")
	public ResponseEntity<UserAuthResponseDTO> autenticacionUsuario(@Valid @RequestBody UserAuthRequestDTO dto) throws UserNotAuthException{
		ResponseEntity<UserAuthResponseDTO> response = null;

		log.info("Se invoca al servicio SIGNIN " + dto.getUsername());
		Authentication sigin = null;
		sigin = jwtTokenUtil.createToken(dto.getUsername(), dto.getPassword());
		
		UserAuthResponseDTO autPass = new UserAuthResponseDTO();
		UserPrincipal userPrincipal = (UserPrincipal) sigin.getPrincipal();
		autPass.setToken(jwtTokenUtil.generateToken(sigin));

		autPass.setUsername(userPrincipal.getUsername());
		autPass.setFullName(userPrincipal.getFullName());
		autPass.setId(userPrincipal.getIdUsuario());

		response = new ResponseEntity<>(autPass, HttpStatus.OK);
		return response;
	}
	
}
