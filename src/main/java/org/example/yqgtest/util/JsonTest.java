package org.example.yqgtest.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.common.util.serialization.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
    map.put("age", null);
    String addString = JsonUtils.toString(map);
    String s1 = JSON.toJSONString(map);
    TestDto end = JsonUtils.fromOrException(addString, TestDto.class);

    String s = "ufjijfid";
    s.length();

    String code = "\"" + "SUMMER" + "\"";
    Season season = JsonUtils.from(code, Season.class);


  }

  @Getter
  @AllArgsConstructor
  public static enum Season {
    SUMMER("S", "summer"),
    WINTER("W", "winter");
    private String code;
    private String desc;
  }

}
