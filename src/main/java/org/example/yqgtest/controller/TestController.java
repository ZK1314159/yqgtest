package org.example.yqgtest.controller;

import org.example.yqgtest.influxdb.InfluxdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  public InfluxdbService influxdbService;

  @GetMapping("/curl")
  public String curl() {
    return "success";
  }

  @GetMapping("/influxdb")
  public String influxdb() {
//    influxdbService.writeNew();
    influxdbService.queryNew();
    return "success";
  }

}
