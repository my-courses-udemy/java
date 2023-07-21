package com.santihs.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {
  @GetMapping(value = "/string")
  public String param(
          @RequestParam(name = "text", defaultValue = "Value by default", required = false) String text,
          Model model) {
    model.addAttribute("title", "Parameter name text");
    model.addAttribute("result", "Text sent is: ".concat(text));

    return "params/see";
  }

  @GetMapping(value = "/mix-params")
  public String param(@RequestParam String greeting, @RequestParam Integer number, Model model) {
    model.addAttribute("title", "Parameter name text");
    model.addAttribute("result",
            "Text greeting is: ".concat(greeting) + ", and the number is: " + number);

    return "params/see";
  }

  @GetMapping(value = "/mix-params-request")
  public String param(HttpServletRequest request, Model model) {
    String greeting = request.getParameter("greeting");
    int number;
    try {
      number = Integer.parseInt(request.getParameter("number"));
    } catch (NumberFormatException e) {
      number = 0;
    }

    model.addAttribute("title", "Parameter name text");
    model.addAttribute("result",
            "Text greeting is: ".concat(greeting) + ", and the number is: " + number);

    return "params/see";
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("title", "Parameter Index");

    return "params/index";
  }
}
