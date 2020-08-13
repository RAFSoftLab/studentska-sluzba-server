package org.raflab.studsluzba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.raflab"})
@EnableJpaRepositories
public class StudsluzbaServerApp {

	public static void main(String[] args) { 
		SpringApplication.run(StudsluzbaServerApp.class, args);

	}

}
