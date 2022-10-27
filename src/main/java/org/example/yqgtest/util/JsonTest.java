package org.example.yqgtest.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

  public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    TestDto test = new TestDto();
    test.setName("name");
    String string = mapper.writeValueAsString(test);

    TestDto newDto = mapper.readValue(string, TestDto.class);
  }

}
