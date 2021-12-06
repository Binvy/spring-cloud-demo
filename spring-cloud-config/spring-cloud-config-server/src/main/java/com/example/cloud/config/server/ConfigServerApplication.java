package com.example.cloud.config.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author binvi
 * @version 1.0
 * @Description: Spring Cloud Config Server
 * @date 2021/11/28 17:55
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigServerApplication.class)
				.properties("spring.config.name=configserver")
				.run(args);
	}

}