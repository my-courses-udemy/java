package com.santihs.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariableController {

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("title", "Variables index (@PathVariable)");
    return "variables/index";
  }

  // ! The name of the variable must be the same in the parameter
  @GetMapping("/string/{text}")
  public String variables(@PathVariable(name = "text") String text, Model model) {
    model.addAttribute("text", text);
    model.addAttribute("title", "Variables text (@PathVariable)");
    return "variables/see";
  }

  @GetMapping("/string/{text}/{number}")
  public String variables(@PathVariable(name = "text") String text, @PathVariable Integer number, Model model) {
    model.addAttribute("text", "The text sent is: " + text + " and the number is: " + number);
    model.addAttribute("title", "Variables text and number (@PathVariable)");
    return "variables/see";
  }
}
