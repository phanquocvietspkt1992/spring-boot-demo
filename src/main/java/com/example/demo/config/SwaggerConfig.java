package com.example.demo.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Spring Boot API")
                        .version("1.0")
                        .description("This is the API documentation for my Spring Boot application")
                        .contact(new Contact()
                                .name("Support")
                                .email("support@example.com")
                                .url("http://example.com")));
    }
}
