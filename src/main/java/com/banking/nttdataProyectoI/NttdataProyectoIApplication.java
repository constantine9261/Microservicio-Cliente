package com.banking.nttdataProyectoI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.reactive.config.EnableWebFlux;

@Lazy
@ComponentScan(lazyInit = true)
@EnableWebFlux
@SpringBootApplication
public class NttdataProyectoIApplication {

	public static void main(String[] args) {
		SpringApplication.run(NttdataProyectoIApplication.class, args);
	}

}
