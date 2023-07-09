package org.example.yqgtest.controller.vo;

import com.miyou.controllers.core.FormConstraints;
import lombok.Data;

@Data
public class ValidTestVo {
  @FormConstraints.RequiredAndNotEmpty
  private Integer id;
  @FormConstraints.RequiredAndNotEmpty
  private String name;
}
