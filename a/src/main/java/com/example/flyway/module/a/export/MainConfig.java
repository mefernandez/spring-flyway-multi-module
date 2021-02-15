package com.example.flyway.module.a.export;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = MainEntityRepository.class)
@EntityScan(basePackageClasses = MainEntity.class)
public class MainConfig {
	
	@Bean
	public FlywayMigrationInitializer moduleFlywayInitializer(DataSource dataSource) {
		Flyway flyway = Flyway.configure()
				.locations("classpath:db/migration/module-a")
				.table("flyway_history_module_a")
				.baselineOnMigrate(true)
				.baselineVersion("0.0.0")
				.dataSource(dataSource)
				.load();
		return new FlywayMigrationInitializer(flyway);
	}	

}
