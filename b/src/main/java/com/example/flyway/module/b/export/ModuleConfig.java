package com.example.flyway.module.b.export;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
//@ComponentScan(basePackageClasses = ModuleController.class)
@EnableJpaRepositories(basePackageClasses = ModuleEntityRepository.class)
@EntityScan(basePackageClasses = ModuleEntity.class)
public class ModuleConfig {
	
	@Bean
	public FlywayMigrationInitializer moduleBFlywayInitializer(DataSource dataSource) {
		Flyway flyway = Flyway.configure()
				.locations("classpath:db/migration/module-b")
				.table("flyway_history_module_b")
				.baselineOnMigrate(true)
				.baselineVersion("0.0.0")
				.dataSource(dataSource)
				.load();
		return new FlywayMigrationInitializer(flyway);
	}

}
