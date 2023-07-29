package com.santihs.web.app.controllers;

import com.santihs.web.app.models.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
  // !There is a problem, (coupling)
  // !SOLUTION: Use ID and interfaces
  // ?Principle Hollywood
  @Autowired
  @Qualifier("MyBeanService") // ?It allows us to choose an implementation by its name (With @qualifier > @primary)
  private IService service;

// ?It's possible to use @autowired in a setter and the constructor, by omitted it also works
//  ?@Autowired
//  ?public IndexController(IService service) {
//  ?  this.service = service;
//  ?}

//  ?  @Autowired
//  ?public void setService(IService service) {
//  ?  this.service = service;
//  ?}

  @GetMapping({"/", "/index", ""})
  public String index(Model model) {
    model.addAttribute("object", service.operation());
    model.addAttribute("title", "IndexController ID");
    return "index";
  }

}
