package com.ms.cliente;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lib.common.session.security.SecurityConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@SpringBootApplication
@ImportAutoConfiguration({ SecurityConfig.class })
@ComponentScan(basePackages = { "com.ms.cliente", "com.lib.common" })
@EntityScan(basePackages = { "com.lib.common.entity" })
@EnableJpaRepositories(basePackages = { "com.ms.cliente.repository", "com.lib.common.repository" })
@Slf4j
public class MsClienteApplication {

	@Value("${api.config.cliente.base.uri}")
	private String urlServicio = "";

	public static void main(String[] args) {
		SpringApplication.run(MsClienteApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("webServerFactoryCustomizer[]::inicia servicio web de cliente");
		return factory -> factory.setContextPath(this.urlServicio);
	}
}
