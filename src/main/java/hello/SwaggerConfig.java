package hello;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				// .apis(RequestHandlerSelectors.basePackage("hello.controller"))
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				// .paths(PathSelectors.ant("/h*"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Test REST API",
				"A testing demo for swagger ui and spring rest",
				"v1",
				"Terms of service",
				new Contact("kan", "www.example.com", "abc@abc.com"),
				"License of API", "www.example.com", Collections.emptyList());
	}
}
