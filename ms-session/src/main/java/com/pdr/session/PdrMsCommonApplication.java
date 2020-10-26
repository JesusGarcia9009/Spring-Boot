package com.pdr.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;



/**
 * @author BS2
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.pdr.common.session.entity"})
public class PdrMsCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdrMsCommonApplication.class, args);
	}

}

