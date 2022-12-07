package org.example.yqgtest.controller;

import org.example.yqgtest.unittest.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @Autowired
  private SimpleService simpleService;

  @GetMapping("/test")
  public Integer test() {
    return simpleService.unitTest();
  }

  @GetMapping("/curl")
  public String curl() {
    return "success";
  }

}
