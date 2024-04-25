package com.ptm.projectintellijexample;

import com.ptm.projectintellijexample.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectIntellijExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectIntellijExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService){
		return (args) -> {
			storageService.init();
		};
	}

}
