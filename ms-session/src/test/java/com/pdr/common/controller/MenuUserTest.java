package com.pdr.common.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pdr.common.session.security.dto.UserPrincipal;
import com.pdr.session.controller.LoginUserController;
import com.pdr.session.controller.MenuUserController;
import com.pdr.session.dto.ApplicationDTO;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;
import com.pdr.session.service.impl.CustomUserDetailsService;


@SpringBootTest
public class MenuUserTest {

	public static final String USUARIO_MOCK = "marcelo.reyes";

	@Autowired
	private LoginUserController controller;
	
	@Autowired
	private MenuUserController menuController;
	
	@Autowired
	public CustomUserDetailsService userCustom;

	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

	@Test
	public void loginSucces() throws Exception {

		UserAuthRequestDTO param = new UserAuthRequestDTO();
		param.setUsername(USUARIO_MOCK);
		param.setPassword(USUARIO_MOCK);

		ResponseEntity<UserAuthResponseDTO> model = (ResponseEntity<UserAuthResponseDTO>) controller.autenticacionUsuario(param);
        assertThat(model.getBody().getUsername()).isEqualTo(USUARIO_MOCK);
        
        UserPrincipal userToken = userCustom.loadUserByUsername(USUARIO_MOCK);
        
        
        ResponseEntity<List<ApplicationDTO>> responseMenu =   menuController.menuLanding(userToken);
        
        assertThat(!responseMenu.getBody().isEmpty()).isEqualTo(Boolean.TRUE);
		
	}
}
