package org.example.yqgtest.influxdb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "influxdb@2")
public class InfluxdbConfigurationDtoV2 {

  private String url;

  private String user;

  private String password;

  private String token;

  private String bucket;

  private String org;
}
