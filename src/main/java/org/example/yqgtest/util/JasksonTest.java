package org.example.yqgtest.util;

import com.yqg.common.util.serialization.JsonUtils;

public class JasksonTest {
  public static void main(String[] args) {
    TestDto test = new TestDto();
    test.name = "test";
    test.setAge(3);
    test.setGender("man");
    String haha = JsonUtils.toString(test);
    String json = "{\"name\":\"xixixi\",\"gender\":\"man\",\"age\":3,\"enumTest\":null}";
    TestDto newTest = (TestDto) JsonUtils.from(json, TestDto.class);
  }
}
