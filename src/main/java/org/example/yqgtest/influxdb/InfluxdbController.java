package org.example.yqgtest.influxdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/influxdb")
public class InfluxdbController {

  @Autowired
  public InfluxdbServiceV1 influxdbService;

  @GetMapping("/write")
  public String write() {
    influxdbService.write();
    return "success";
  }

  @GetMapping("/query")
  public String query() {
    influxdbService.query();
    return "success";
  }

}
