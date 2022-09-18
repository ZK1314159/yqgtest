package org.example.yqgtest.influxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfluxdbServiceV2 {

//  @Autowired
  private InfluxDBClient influxDBClient;

  @Autowired
  private InfluxdbConfigurationDtoV2 configDto;

  public void write() {
    Point point = Point.measurement("airSensors3")
        .time(1662973980000000000L, WritePrecision.NS)
        .addTag("sensor_id", "TLM0201")
        .addField("temperature", 89.97038159354763);
    influxDBClient.getWriteApiBlocking().writePoint(configDto.getBucket(), configDto.getOrg(), point);
  }

  public void query() {
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
