package com.santihs.web.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("MyComplexService")
@Primary // ? We declare this class to use by default
// !Service provides a semantic
//@Service
public class MyComplexService implements IService {

  // !If we have a constructor with parameters, we need to initialize one without parameters
  public MyComplexService() {
  }

  // !Indicates it's the implementation
  @Override
  public String operation() {
    return "Executing something more complex...";
  }
}
