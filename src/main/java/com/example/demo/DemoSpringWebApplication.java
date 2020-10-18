package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
@RequestMapping("/hello")
public class DemoSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringWebApplication.class, args);
	}
	@GetMapping
	public String sayHello(){
		return "Hello World";
}
}
