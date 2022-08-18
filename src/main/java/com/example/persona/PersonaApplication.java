package com.example.persona;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PersonaApplication {

  public static void main(String[] args) {
    SpringApplication.run(PersonaApplication.class, args);
  }


  /**
   * Custom open api open api.
   *
   * @return the open api
   */
  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info()
            .title("Persona")
            .description("Persona API Documentation "));
  }
}
