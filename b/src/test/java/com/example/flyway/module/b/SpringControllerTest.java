package com.example.flyway.module.b;

import static org.junit.jupiter.api.Assertions.*;

import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;

import com.example.flyway.module.b.main.ModuleApplication;

@DirtiesContext
@Tag("IntegrationTest")
@SpringBootTest(classes = ModuleApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(properties = "server.port=7080")
class SpringControllerTest {

	@Test
	@DisplayName("GET http://localhost:7080/module-b/hello")
	void testGetHello() throws Exception {
		assertEquals(200, Request.Get("http://localhost:7080/module-b/hello").execute().returnResponse().getStatusLine().getStatusCode());
	}

}
