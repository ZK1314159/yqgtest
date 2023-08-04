package org.example.yqgtest.util.json;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Season {
  SUMMER("S", "summer"),
  WINTER("W", "winter");
  private String code;
  private String desc;

  @JsonValue
  public String getCode() {
    return code;
  }
}
