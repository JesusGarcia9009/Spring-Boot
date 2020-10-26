package com.pdr.common.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.pdr.session.controller.impl.LoginUserControllerImpl;
import com.pdr.session.dto.UserAuthRequestDTO;
import com.pdr.session.dto.UserAuthResponseDTO;


@SpringBootTest
class LoginUserTest {
	// Data
		public static final String USUARIO_MOCK = "marcelo.reyes";

		@Autowired
		private LoginUserControllerImpl controller;
		

		@Test
		public void contexLoads() throws Exception {
			assertThat(controller).isNotNull();
		}

		@Test
		public void autenticacionUsuarioTest() throws Exception {

			UserAuthRequestDTO param = new UserAuthRequestDTO();
			param.setUsername(USUARIO_MOCK);
			param.setPassword(USUARIO_MOCK);

			ResponseEntity<UserAuthResponseDTO> model = (ResponseEntity<UserAuthResponseDTO>) controller.autenticacionUsuario(param);
            assertThat(model.getBody().getUsername()).isEqualTo(USUARIO_MOCK);
			
		}

}
