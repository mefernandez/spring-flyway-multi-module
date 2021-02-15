package com.example.flyway.module.a.export;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.example.flyway.module.b.export.ModuleConfig;

@Configuration
@Import(ModuleConfig.class)
@ComponentScan(basePackageClasses = ModuleConfig.class)
public class ImportModuleConfig {
	
}
