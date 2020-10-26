package com.pdr.session.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author BS2.
 */
@Configuration
public class DozerConfig {

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return new DozerBeanMapper();
    }
}
