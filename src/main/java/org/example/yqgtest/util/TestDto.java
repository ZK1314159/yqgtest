package org.example.yqgtest.util;

import lombok.Data;

@Data
public class TestDto {

  public String name;

  private String gender;

  private Integer age;

  private EnumTest enumTest;

//  public void setName(String name) {
//    this.name = "jdhfdj";
//  }

//  @JsonIgnore
  public String getCode() {
    return "test";
  }

  public void setCode(String code) {
  }

}
