package com.jsp.wm.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {

	
	//http://localhost:8080/swagger-ui.html
	
	@Bean
	 OpenAPI openAPI(){
		return new OpenAPI().info(new Info()
				.title("Warehouse-Manager")
				.version("v1")
				.description("Spring Boot Application built using `RESTFUL` architecture, performs basic **CRUD** operations\n"+
						"### Features:\n"+
						"- Covers all CRUD operations\n"+"- Perfomed Field Validations\n"+"- Used DTOs to control inbound and outbound data"));
	}
}
