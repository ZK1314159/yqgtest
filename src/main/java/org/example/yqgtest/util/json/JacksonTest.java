package org.example.yqgtest.util.json;

import com.yqg.common.util.serialization.JsonUtils;

public class JacksonTest {
  public static void main(String[] args) {
    PlainDto plainDto = PlainDto.builder().build();
    String string = JsonUtils.toString(plainDto);
    System.out.println(string);
  }
}
