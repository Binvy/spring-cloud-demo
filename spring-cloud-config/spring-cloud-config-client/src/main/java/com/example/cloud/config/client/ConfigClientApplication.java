package com.example.cloud.config.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author binvi
 * @version 1.0
 * @Description: Spring Cloud Config Client BootStrap Application
 * @date 2021/11/28 17:44
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	@Value("${config.info:}")
	String name = "World";

	private Environment environment;

	public ConfigClientApplication(Environment environment) {
		this.environment = environment;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello " + name;
	}

	@GetMapping("/query")
	public String query(@RequestParam("q") String q) {
		return this.environment.getProperty(q);
	}

}
