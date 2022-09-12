package org.example.yqgtest.influxdb;

import lombok.extern.slf4j.Slf4j;
import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InfluxdbConfiguration {

  @Autowired
  private InfluxdbConfigurationDto configDto;

  @Bean
  public InfluxDB influxDB() {
    InfluxDB influxDB = InfluxDBFactory.connect(configDto.getUrl(), configDto.getUser(), configDto.getPassword());
    BatchOptions options = BatchOptions.DEFAULTS
        .actions(5000)
        .flushDuration(100)
        .dropActionsOnQueueExhaustion(true)
        .droppedActionHandler(point -> log.warn("drop actions on queue exhaustion"));
    influxDB.enableBatch(options);
    return influxDB;
  }

}
