package com.example.APIgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableEurekaClient
@Configuration
public class ApIgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApIgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/api/v1/auth/**")
						.uri("http://localhost:8081/"))

				.route(p -> p
						.path("/api/v1/restaurant/**")
						.uri("http://localhost:8082/"))

				.route(p -> p
						.path("/api/v1/user/**")
						.uri("http://localhost:8083/"))
				.route(p -> p
						.path("/api/v1/notification/**")
						.uri("http://localhost:7171/"))
				.build();
	}
}
