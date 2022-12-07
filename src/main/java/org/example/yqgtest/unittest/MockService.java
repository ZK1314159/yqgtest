package org.example.yqgtest.unittest;

import org.springframework.stereotype.Component;

@Component
public class MockService {

  public Integer test() {
    return 1;
  }

  public static void main(String[] args) {
    String string = String.format("结清试算失败，原因：%s", null);
    System.out.println(string);
  }

}
