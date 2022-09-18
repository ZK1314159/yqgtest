package org.example.yqgtest.influxdb;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class InfluxdbServiceV1 {

  @Autowired
  private InfluxDB influxDB;

  @Autowired
  private InfluxdbConfigurationDtoV1 configDto;

  public void write() {
    Point point = Point.measurement("performance2")
        .time(getNanoTimeOfNow(), TimeUnit.NANOSECONDS)
        .tag("cpu", "cpu1")
        .addField("use", 45)
        .addField("storage", 78)
        .build();
    influxDB.write(configDto.getDbname(), configDto.getRetentionPolicy(), point);
  }

  private long getNanoTimeOfNow() {
    long now = System.currentTimeMillis();
    return now * 1_000_000L;
  }

  public void query() {
    String sql = "select * from performance2 tz('Asia/Shanghai')";
    Query query = new Query(sql, configDto.getDbname());
    QueryResult queryResult = influxDB.query(query);
  }

}
