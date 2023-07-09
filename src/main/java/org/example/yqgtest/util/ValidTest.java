package org.example.yqgtest.util;

import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Component
public class ValidTest {

  @Data
  @Builder
  public static class Param {
    @NotNull
    private Integer id;
    @NotEmpty
    private String name;
  }

  void test(@Validated Param param) {
    System.out.println("test");
  }

}
