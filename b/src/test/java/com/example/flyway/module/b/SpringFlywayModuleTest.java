package com.example.flyway.module.b;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.flyway.module.b.export.ModuleEntity;
import com.example.flyway.module.b.export.ModuleEntityRepository;
import com.example.flyway.module.b.main.ModuleApplication;

@SpringBootTest(classes = ModuleApplication.class)
class SpringFlywayModuleTest {
	
	@Autowired
	private ModuleEntityRepository repository;
	
	@Sql(statements = "INSERT INTO module_entity (id, val) VALUES (1, 'module entity')")
	@Test
	void testFindEntityFromModuleRepository() {
		ModuleEntity mainEntity = repository.findById(1L).get();
		assertEquals("module entity", mainEntity.getVal());
	}

}
