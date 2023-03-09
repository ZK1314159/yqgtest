package org.example.yqgtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.yqgtest.unittest.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
//@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
public class TestController {

  @Autowired
  private SimpleService simpleService;
//  private final String string = "test";

  @GetMapping("/test")
  public Integer test() {
//    log.info(string);
    return simpleService.unitTest();
  }

  @GetMapping("/curl")
  public String curl() {
    return "success";
  }

}
