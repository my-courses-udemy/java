package com.santihs.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String home() {
    // !Redirect restart the request
//    ?return "redirect:/app/";
//    ?return "redirect:https://www.google.com";
    // !Other way is with forward without restarting the page, the path doesnt change
    // !the forward executes a request dispatcher
    return "forward:/app/";
  }
}
