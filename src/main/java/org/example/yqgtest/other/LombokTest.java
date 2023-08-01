package org.example.yqgtest.other;

import com.yqg.common.util.serialization.JsonUtils;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokTest {

  @Builder
  @Data
  public static class SampleDto {
    private int id;
    @Builder.Default
    private String name = "default";
    private int age;
  }

  public static class PlainDto {
    private int id;
    private String name;
    private int age;
  }


  public static void main(String[] args) {
    SampleDto test = SampleDto.builder().id(1).age(12).build();
    String string = test.toString();
    PlainDto plianDto = new PlainDto();
    plianDto.id = 2;
    plianDto.age = 20;
    String string2 = plianDto.toString();
    JsonUtils.from(JsonUtils.toString(test), SampleDto.class);
  }

}
