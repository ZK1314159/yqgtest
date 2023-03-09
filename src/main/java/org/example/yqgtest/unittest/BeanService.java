package org.example.yqgtest.unittest;

import org.springframework.stereotype.Component;

@Component
public class BeanService {

  private Integer integer = 3;
  private String string = "hahha";

  public Integer unitTest() {
    return 1;
  }
}
