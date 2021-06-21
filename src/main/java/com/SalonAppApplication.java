package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@SpringBootApplication
public class SalonAppApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(SalonAppApplication.class, args);
		System.out.println("**********************************  WELCOME TO ONLINE SALON SERVICES  **************************");
		System.out.println("=======================================(   ENJOY THE SERVICE    )===============================");
	}
	
	@Bean
	   public Docket productApi() 
	{
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.salon.rest")).build();
	}
	
	//URL To Use Swagger
	//http://localhost:8089/swagger-ui/index.html

}
