package org.example.yqgtest.util;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDto {

  public String name;

  private String gender;

  private Integer age;

  private EnumTest enumTest;

  private boolean success;

  private Boolean crash;

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
