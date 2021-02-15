package com.example.flyway.module.a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.flyway.module.a.export.MainEntity;
import com.example.flyway.module.a.export.MainEntityRepository;
import com.example.flyway.module.a.main.MainApplication;
import com.example.flyway.module.b.export.ModuleEntity;
import com.example.flyway.module.b.export.ModuleEntityRepository;

@SpringBootTest(classes = MainApplication.class)
class SpringModularFlywayTest {
	
	@Autowired
	private MainEntityRepository mainRepository;
	
	@Autowired
	private ModuleEntityRepository moduleRepository;
	
	@Sql(statements = "INSERT INTO main_entity (id, val) VALUES (1, 'main entity')")
	@Sql(statements = "INSERT INTO module_entity (id, val) VALUES (1, 'module entity')")
	@Test
	void testFindEntityFromMainAndModuleRepositories() {
		MainEntity mainEntity = mainRepository.findById(1L).get();
		assertEquals("main entity", mainEntity.getVal());
		ModuleEntity moduleEntity = moduleRepository.findById(1L).get();
		assertEquals("module entity", moduleEntity.getVal());
	}


}
