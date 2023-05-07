package org.example.yqgtest.util;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yqg.common.util.clock.YqgClock;
import com.yqg.common.util.serialization.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    TestDto test = TestDto.builder()
      .name("name")
      .success(true)
      .crash(false)
      .build();
    String testString = JsonUtils.toString(test);
    TestDto newTest = JsonUtils.from(testString, TestDto.class);
    ObjectMapper mapper = new ObjectMapper();
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

    test.setEnumTest(EnumTest.SUMMER);
    String jsonString = JsonUtils.toString(test);
    jsonString = jsonString.replaceAll("SUMMER", "s99s1");
//    TestDto reverseDto = JsonUtils.fromOrException(jsonString, TestDto.class);
    Map<String, String> map1 = JsonUtils.from(jsonString, HashMap.class);
    List<?> list = new ArrayList<>(map1.values());
    String s2 = DateTimeFormatter.ISO_LOCAL_DATE.toString();
    Long date = YqgClock.dateStringToLong("2019-01-01", DateTimeFormatter.ISO_LOCAL_DATE.toString());
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
