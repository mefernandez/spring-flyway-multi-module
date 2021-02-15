package com.example.flyway.module.b.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

import com.example.flyway.module.b.export.ModuleConfig;

@SpringBootApplication(scanBasePackageClasses = ModuleConfig.class)
public class ModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApplication.class, args);
	}

}
