package org.raflab.studsluzba;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerAppConfig {
	
	@PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));     
        
        
    }
}
