package com.pdr.session.controller.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdr.common.exception.UserNotAuthException;
import com.pdr.common.session.security.dto.UserPrincipal;
import com.pdr.session.controller.LoginUserController;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;
import com.pdr.session.utils.JwtTokenUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${api.config.common.base.uri}/login")
@Slf4j
public class LoginUserControllerImpl implements LoginUserController {

	@Value("${api.losparques.mock.username.list}")
	private String mockUsernameBypass;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	public AuthenticationManager authenticationManager;

	@Autowired
	public JwtTokenUtil jwtTokenUtil;

	@Autowired
	UserDetailsService userDetailsService;

	@PostMapping("/auth")
	public ResponseEntity<UserAuthResponseDTO> autenticacionUsuario(@Valid @RequestBody UserAuthRequestDTO dto)
			throws UserNotAuthException, BadCredentialsException {
		ResponseEntity<UserAuthResponseDTO> response = null;

		log.info("Se invoca al servicio SIGNIN " + dto.getUsername());
		Authentication sigin = null;
		try {
			sigin = jwtTokenUtil.createToken(dto.getUsername(), dto.getPassword());
		}catch (BadCredentialsException e1) {
			throw new UserNotAuthException(e1.getMessage());
		}catch (Exception e) {
			throw new UserNotAuthException(e.getMessage());
		}
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
