package com.yian.crud_spring.config;

import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.url("http://localhost:8080");
        devServer.description("local Dev Server");

        Server prodServer=new Server();
        prodServer.url("https://yian-crud-spring.example.com");
        prodServer.description("Production Server");

        Contact contact = new Contact();
        contact.name("Yian");
        contact.email("yian.choi05@gmail.com");
        contact.url("https://yian-crud-spring.example.com");

        License mitLicense = new License();
        mitLicense.name("MIT License");
        mitLicense.url("https://opensource.org/licenses/MIT");

        Info info = new Info()
                .title("Crud Spring Boot")
                .description("Spring Boot RESTful API")
                .version("v1.0.0")
                .contact(contact)
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer,prodServer));

    }
}
