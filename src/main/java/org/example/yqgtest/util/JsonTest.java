package org.example.yqgtest.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.common.util.serialization.JsonUtils;

import java.util.HashMap;
import java.util.Map;

public class JsonTest {

  public static void main(String[] args) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    TestDto test = new TestDto();
    test.setName("name");
    String string = mapper.writeValueAsString(test);
    TestDto newDto = mapper.readValue(string, TestDto.class);

    Map<String, String> map = JsonUtils.fromOrException(string, HashMap.class);
    map.put("gender", "man");
    String addString = JsonUtils.toString(map);
    TestDto end = JsonUtils.fromOrException(addString, TestDto.class);

    String s = "ufjijfid";
    s.length();


  }

}
