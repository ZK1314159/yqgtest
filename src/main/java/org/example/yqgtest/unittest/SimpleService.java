package org.example.yqgtest.unittest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleService {

  @Autowired
  private MockService mockService;

  public Integer unitTest() {
    return 1;
  }

}
