package org.example.yqgtest.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ValidTestTest {

  @Autowired
  private ValidTest validTest;

  @Test
  public void test() {
    validTest.test(ValidTest.Param.builder().build());
  }

}