package org.example.yqgtest.influxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class InfluxdbService {

  private String dbname = "test";

  private String retentionPolicy = "default";

  @Autowired
  private InfluxDB influxDB;

  @Autowired
  private InfluxDBClient influxDBClient;

  @Autowired
  private InfluxdbConfigurationDto configDto;

  public void write() {
    org.influxdb.dto.Point point = org.influxdb.dto.Point.measurement("airSensors3")
        .time(1662969980000000000L, TimeUnit.NANOSECONDS)
        .tag("sensor_id", "TLM0201")
        .addField("temperature", 89.97038159354763)
        .build();
    influxDB.write(dbname, retentionPolicy, point);
    // 用1.x版本的influxdb方式连接会因token问题无法查询，写入没有报错但在2.4的数据库中无法查询插入结果
    String sql = "SELECT * FROM \"test\" WHERE time > '2022-01-16'  tz('Asia/Shanghai')";
    Query query = new Query(sql, dbname);
    QueryResult queryResult = influxDB.query(query);
  }

  public void writeNew() {
    Point point = Point.measurement("airSensors3")
        .time(1662973980000000000L, WritePrecision.NS)
        .addTag("sensor_id", "TLM0201")
        .addField("temperature", 89.97038159354763);
    influxDBClient.getWriteApiBlocking().writePoint(configDto.getBucket(), configDto.getOrg(), point);
  }

  public void queryNew() {
    String query = "from(bucket: \"test\")\n" +
        "  |> range(start: -30d)\n" +
        "  |> filter(fn: (r) => r[\"_measurement\"] == \"airSensors3\")\n" +
        "  |> filter(fn: (r) => r[\"_field\"] == \"temperature\")\n" +
        "  |> filter(fn: (r) => r[\"sensor_id\"] == \"TLM0201\")\n" +
        "  |> aggregateWindow(every: 1h, fn: mean, createEmpty: false)\n" +
        "  |> yield(name: \"mean\")";
    String query2 = "from(bucket: \"test\")\n" +
        "  |> range(start: -30d)\n" +
        "  |> filter(fn: (r) => r[\"_measurement\"] == \"airSensors3\")\n" +
        "  |> filter(fn: (r) => r[\"_field\"] == \"temperature\")\n" +
        "  |> filter(fn: (r) => r[\"sensor_id\"] == \"TLM0201\")\n" +
        "  |> yield()";
    List<FluxTable> fluxTables = influxDBClient.getQueryApi().query(query2, configDto.getOrg());
  }

}
