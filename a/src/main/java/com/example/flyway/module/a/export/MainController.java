package com.example.flyway.module.a.export;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@GetMapping(path = "/module-a/hello")
	public String getHello() {
		return "Hello from Module A";
	}

}
