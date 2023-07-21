package com.santihs.web.app.controllers;

import com.santihs.web.app.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

// !There are many options to pass attributes
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// !Take a root /app/* all the methods we create into the class
@RequestMapping("/app")
public class IndexController {
  @Value("${index.controller.index.text}")
  private String indexText;
  @Value("${index.controller.index.title}")
  private String listTitle;
  @Value("${index.controller.index.profile}")
  private String profile;

  //  ?@RequestMapping(value = "/index", method = RequestMethod.GET)
  @GetMapping({"/", "/home", "/index"})
  public String index(Model model) {
    model.addAttribute("title", indexText);
//    ?map.put("title", "Hello World from Spring with map");
//    ?mv.addObject("title", "Hello World from Spring with model and view");
    return "index";
//    ?mv.setViewName("index");
//    ?return mv;
  }

  @GetMapping("/profile")
  public String profile(Model model) {
    User user = new User();
    user.setName("Sho");
    user.setLastName("Test");
    user.setEmail("santihs@gmail.com");

    model.addAttribute("user", user);
    model.addAttribute("title", profile.concat(user.getName()));
    return "profile";
  }

  @GetMapping("/list")
  public String list(Model model) {
//    List<User> users = Arrays.asList(new User("Santi", "Sanchez", "santihs@gmail.com"),
//            new User("Sho", "Test", "sho@gmail.com"),
//            new User("Java", "Next", "java@gmail.com"));
//
//    model.addAttribute("users", users);
    model.addAttribute("title", listTitle);
    return "list";
  }

  @ModelAttribute("users")
  public List<User> getUsers() {
    // !We pass data to the view, this attribute is available in all the controller methods
    return Arrays.asList(new User("Santi", "Sanchez", "santihs@gmail.com"),
            new User("Sho", "Test", "sho@gmail.com"),
            new User("Java", "Next", "java@gmail.com"));
  }
}
