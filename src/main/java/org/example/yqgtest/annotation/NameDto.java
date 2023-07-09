package org.example.yqgtest.annotation;

import lombok.Data;

@Data
//@Name("姓名1")
public class NameDto {
  @Name("姓名")
  private String name;
  private Integer id;
}
