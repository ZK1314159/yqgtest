package org.example.yqgtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.yqgtest.controller.vo.ValidTestVo;
import org.example.yqgtest.unittest.SimpleService;
import org.example.yqgtest.util.ParamCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//@AllArgsConstructor
//@NoArgsConstructor
@Slf4j
public class TestController {

  @Autowired
  private SimpleService simpleService;
//  private final String string = "test";

  @Autowired
  private ParamCheckUtil paramCheckUtil;

  @GetMapping("/test")
  public Integer test() {
//    log.info(string);
    return simpleService.unitTest();
  }

  @GetMapping("/curl")
  public String curl() {
    return "success";
  }

  @GetMapping("/curl2")
  public String paramCheck() {
//    ParamCheckUtil.Param param = ParamCheckUtil.Param.builder().id(1).name("hhaj").values(Lists.newArrayList(1)).build();
    ParamCheckUtil.Param param = ParamCheckUtil.Param.builder().build();
    ParamCheckUtil.Result result = paramCheckUtil.validate(param);
    return "success";
  }

  @PostMapping("/valideTest")
  public String yqgValidTest(@RequestBody ValidTestVo validTestVo) {
    return "success";
  }

}
