package org.example.yqgtest.influxdb;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "influxdb@1")
public class InfluxdbConfigurationDtoV1 {

  private String url;

  private String user;

  private String password;

  private String dbname;

  private String retentionPolicy;

}
