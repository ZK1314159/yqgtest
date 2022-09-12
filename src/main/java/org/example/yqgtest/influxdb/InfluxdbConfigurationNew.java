package org.example.yqgtest.influxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfluxdbConfigurationNew {

  @Autowired
  private InfluxdbConfigurationDto influxdbConfigurationDto;

  @Bean
  public InfluxDBClient influxDBClient() {
    String url = influxdbConfigurationDto.getUrl();
    String token = influxdbConfigurationDto.getToken();
    return InfluxDBClientFactory.create(url, token.toCharArray());
  }

}
