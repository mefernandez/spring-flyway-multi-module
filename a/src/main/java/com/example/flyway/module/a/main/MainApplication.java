package com.example.flyway.module.a.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.flyway.module.a.export.MainConfig;

@SpringBootApplication(scanBasePackageClasses = MainConfig.class)
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

}
