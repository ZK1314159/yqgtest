package org.example.yqgtest.unittest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SimpleServiceTest {

  @Autowired
  private SimpleService simpleService;

  @Test
  public void test() {
    Integer result = simpleService.unitTest();
    System.out.println(result);
  }

}