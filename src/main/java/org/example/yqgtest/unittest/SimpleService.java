package org.example.yqgtest.unittest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
//@NoArgsConstructor
public class SimpleService {

  private MockService mockService;
//  public SimpleService(MockService mockService) {
//    this.mockService = mockService;
//  }

  public Integer unitTest() {
    return mockService.test();
  }

}
