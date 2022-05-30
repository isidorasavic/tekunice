package com.sbnz.tekunicebackend;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TekuniceBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TekuniceBackendApplication.class, args);
		System.out.println("Hello world :)");
	}

	@Bean
    public KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }

}
