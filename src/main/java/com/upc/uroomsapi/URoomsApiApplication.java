package com.upc.uroomsapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class URoomsApiApplication  implements CommandLineRunner {
    //LOGGER
    private static final Logger Log = LoggerFactory.getLogger(URoomsApiApplication.class);

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

    //METODO MAIN
    public static void main(String[] args) {
        SpringApplication.run(URoomsApiApplication.class, args);
    }

    //VERIFICAR EL ENTORNO DE EJECUCION (DEV o PROD)
    @Value(value = "${environment}")
    String env;

    @Override
    public void run(String... arg0) {
        Log.warn("************ ENV: {} ************", env);
    }
}
