package org.example.yqgtest.unittest;

import org.springframework.stereotype.Component;

@Component
//@AllArgsConstructor
//@NoArgsConstructor
public class SimpleService {

  private final MockService mockService;
  private final BeanService beanService;

  public SimpleService(MockService mockService, BeanService beanService) {
    this.mockService = mockService;
    this.beanService = beanService;
  }

  private Integer integer = 3;
  private String string = "hahha";
  private static final String test = "fjhdf";
//  public SimpleService(MockService mockService) {
//    this.mockService = mockService;
//  }

  public Integer unitTest() {
    return mockService.test();
  }

}
