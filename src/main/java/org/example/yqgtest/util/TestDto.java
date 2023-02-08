package org.example.yqgtest.util;

import lombok.Data;

@Data
public class TestDto {

  private String name;

  private String gender;

  public String getCode() {
    return "test";
  }

  public void setCode(String code) {
  }

}
