package com.pdr.cobranza.cliente;

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

import com.pdr.common.session.security.SecurityConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@SpringBootApplication
@ImportAutoConfiguration({ SecurityConfig.class })
@ComponentScan(basePackages = { "com.pdr.cobranza.cliente", "com.pdr.common" })
@EntityScan(basePackages = { "com.pdr.common.cobranza.entity", "com.pdr.common.session.entity" })
@EnableJpaRepositories(basePackages = { "com.pdr.cobranza.cliente.repository", "com.pdr.common.cobranza.repository",
		"com.pdr.common.session.repository" })
@Slf4j
public class PdrMsCobranzaClienteApplication {

	@Value("${api.config.cobranza.cliente.base.uri}")
	private String urlServicio = "";

	public static void main(String[] args) {
		SpringApplication.run(PdrMsCobranzaClienteApplication.class, args);
	}

	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("webServerFactoryCustomizer[]::inicia servicio web de cliente");
		log.info("webServerFactoryCustomizer[]::uri-->"+ urlServicio);
		return factory -> factory.setContextPath(this.urlServicio);
	}
}
