package com.demov2.apisablon;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApisablonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApisablonApplication.class, args);
	}

	/*@Bean
	public OpenAPI customOpenAPI()
	{
		return new OpenAPI()
				.info(new Info()
						.title("Api Sablon API")
						.version("1.0")
						.description("Api Şablon")
						.license(new License().name("Sablon API lisansı")));
	}*/
}
