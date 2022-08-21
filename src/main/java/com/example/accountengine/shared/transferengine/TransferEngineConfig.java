package com.example.accountengine.shared.transferengine;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties(prefix = "transfer-engine")
@Getter
@Setter
@Validated
public class TransferEngineConfig {

  private String host;
  private int port;


}
