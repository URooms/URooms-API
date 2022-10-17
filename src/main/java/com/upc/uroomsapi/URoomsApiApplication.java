package com.upc.uroomsapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class URoomsApiApplication {
    //BEANS
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(new Info()
                .title("URooms API")
                .description("Documentación del backend de URooms")
                .version("1.0.0")
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(URoomsApiApplication.class, args);
    }
}
