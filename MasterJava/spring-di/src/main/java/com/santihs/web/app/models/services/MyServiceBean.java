package com.santihs.web.app.models.services;

public class MyServiceBean implements IService {

  public MyServiceBean() {
  }

  // !Indicates it's the implementation
  @Override
  public String operation() {
    return "Executing something bean task...";
  }
}
