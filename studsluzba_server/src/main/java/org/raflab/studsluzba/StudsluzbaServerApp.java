package org.raflab.studsluzba;

import org.raflab.studsluzba.controllers.security.AppUserProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.raflab"})
@EnableJpaRepositories
@EnableConfigurationProperties(AppUserProperties.class)
public class StudsluzbaServerApp {

	public static void main(String[] args) { 
		SpringApplication.run(StudsluzbaServerApp.class, args);

	}

}
