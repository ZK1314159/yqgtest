package org.example.yqgtest.unittest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SimpleServiceTest {

  @Autowired
  private SimpleService simpleService;

//  @SpyBean
//  private MockService mockService;

  @Test
  public void test() {
    Integer result = simpleService.unitTest();
    System.out.println(result);
  }

}