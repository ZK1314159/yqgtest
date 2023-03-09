package org.example.yqgtest.unittest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
@AllArgsConstructor
public class SimpleService {

  private final MockService mockService;
  private final BeanService beanService;

//  private Integer integer = 3;
  private static String test = "fjhdf";

//  public SimpleService(MockService mockService, BeanService beanService) {
//    this.mockService = mockService;
//    this.beanService = beanService;
//  }


  public Integer unitTest() {
    Class<SimpleService> simpleServiceClass = SimpleService.class;
    Constructor[] constructors = simpleServiceClass.getDeclaredConstructors();
    beanService.unitTest();
    return mockService.test();
  }

}
