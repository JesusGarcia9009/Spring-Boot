package com.ms.config.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author BS2
 */
@RestController
@RequestMapping(method = { org.springframework.web.bind.annotation.RequestMethod.GET }, path = {
		"${spring.cloud.config.server.prefix:ic.pdr.local}" })
public class ConfigServerController {

	@RequestMapping({ "/config-error" })
	public String configWithError() {
		return "No config error found";
	}

}
