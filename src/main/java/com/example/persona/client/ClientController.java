package com.example.persona.client;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "client")
@Validated
@Tag(name = "Client Controller")
@Log4j2
@AllArgsConstructor
public class ClientController {

  @PostMapping
  public ResponseEntity<String> addClient(@RequestBody String payload) {
    log.info("The input is: {}", payload);
    return ResponseEntity.status(HttpStatus.OK).body("Success");
  }

}
