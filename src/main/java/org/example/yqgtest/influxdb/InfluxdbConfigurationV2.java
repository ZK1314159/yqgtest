package org.example.yqgtest.influxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

//@Configuration
public class InfluxdbConfigurationV2 {

  @Autowired
  private InfluxdbConfigurationDtoV2 influxdbConfigurationDtoV2;

  @Bean
  public InfluxDBClient influxDBClient() {
    String url = influxdbConfigurationDtoV2.getUrl();
    String token = influxdbConfigurationDtoV2.getToken();
    return InfluxDBClientFactory.create(url, token.toCharArray());
  }

}
