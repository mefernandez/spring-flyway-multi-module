package com.example.flyway.module.a;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.example.flyway.module.a.export.ImportModuleConfig;
import com.example.flyway.module.a.export.MainConfig;
import com.example.flyway.module.a.main.MainApplication;
import com.example.flyway.module.b.export.ModuleConfig;


class FoundMoreThanOneMigrationExceptionTest {
	
	@SpringBootApplication
	@ComponentScan(
			excludeFilters = {
				@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
						MainApplication.class,
						MainConfig.class,
						ImportModuleConfig.class,
						ModuleConfig.class, 
						}),
		})
	public static class MainTestApplication {
		
	}
	
	@Test
	void testFlywayThrowsExceptionWhenMoreThanOneMigrationWithSameVersionIsFound() {
		// Default Flyway locations is db/migration, which includes scripts from both main and module
		SpringApplication springApplication = new SpringApplication(MainTestApplication.class);
		BeanCreationException e = assertThrows(BeanCreationException.class, () -> {springApplication.run();});
		assertThat(e.getCause().getMessage(), startsWith("Found more than one migration with version 0.0.1.000"));
	}

}
