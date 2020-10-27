package com.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BS2
 */
@Slf4j
@SpringBootApplication
@EntityScan(basePackages = { "com.lib.common.entity" })
public class MsSessionApplication {
	
	@Value("${api.config.base.uri}")
	private String urlServicio = "";

	public static void main(String[] args) {
		SpringApplication.run(MsSessionApplication.class, args);
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		log.info("[webServerFactoryCustomizer] :: "+ urlServicio);
		return factory -> factory.setContextPath(this.urlServicio);
	}

}
