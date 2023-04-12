package com.vegetable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.securityContexts(Arrays.asList(securityContext())).securitySchemes(Arrays.asList(apiKey())).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("My REST API", "Some custom description of API.", "1.0", "Terms of service",
				new Contact("vegetable-sales", "www.vegetablesales.com", "vegetable@gmail.com"), "Apache 2.0",
				"\"https://www.apache.org/licenses/LICENSE-2.0\"", Collections.emptyList());
	}
	/*
	 * For Swagger api doc generation: http://localhost:9091/v2/api-docs or
	 * http://localhost:9091/v3/api-docs
	 */
	/*
	 * For Swagger ui: http://localhost:9091/swagger-ui/ or
	 * http://localhost:9091/swagger-ui/index.html
	 */
}