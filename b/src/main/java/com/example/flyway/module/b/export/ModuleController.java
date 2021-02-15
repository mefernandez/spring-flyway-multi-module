package com.example.flyway.module.b.export;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModuleController {
	
	@GetMapping(path = "/module-b/hello")
	public String getHello() {
		return "Hello from Module B";
	}

}
