package com.santihs.web.app.controllers;

import com.santihs.web.app.models.domain.User;
import com.santihs.web.app.validator.UserValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
//! user is stored in a http session, updating data if it's necessary
@SessionAttributes("user")
@AllArgsConstructor
public class FormController {

  private UserValidator userValidator;

  // !Add other customized validator
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.addValidators(userValidator);
  }

  @GetMapping("/form")
  public String form(Model model) {
    User user = new User();
    user.setName("John");
    user.setLastName("Doe");
    user.setId("123-232-565-KFC"); //! It is override to null
    model.addAttribute("title", "User Form");
    model.addAttribute("user", user);
    return "form";
  }

  // ? Take the variables by their names
  // ? BindingResult must be after the object to validate
  // ? Model is always the last one
  @PostMapping("/form")
  //? The user is passed automatically to the view if there is an error (the name by default will be user)
  //? With @ModelAttribute is possible to change the name
  public String processForm(@Valid User user, BindingResult result, Model model,
                            SessionStatus status) {
//                            !@RequestParam(name = "username") String username,
//                            !@RequestParam(value = "password") String password,
//                            !@RequestParam String email) {
    model.addAttribute("title", "Result of Form");
    if (result.hasErrors()) {
      // !Manual form
      // !Map<String, String> errors = new HashMap<>();
      // !result.getFieldErrors()
      // !        .forEach(error -> errors.put(error.getField(), "Error in: " + error.getField()
      // !                + " with message: " + error.getDefaultMessage()));
      // !model.addAttribute("errors", errors);
      return "form";
    }
    model.addAttribute("user", user);
    status.setComplete(); //! Close the session
    return "result";
  }
}
