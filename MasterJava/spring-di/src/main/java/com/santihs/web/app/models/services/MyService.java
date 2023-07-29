package com.santihs.web.app.models.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component("MySimpleService")
// !Service provides a semantic
//@Service
public class MyService implements IService {

  // !If we have a constructor with parameters, we need to initialize one without parameters
  public MyService() {
  }

  // !Indicates it's the implementation
  @Override
  public String operation() {
    return "Executing something important...";
  }
}
