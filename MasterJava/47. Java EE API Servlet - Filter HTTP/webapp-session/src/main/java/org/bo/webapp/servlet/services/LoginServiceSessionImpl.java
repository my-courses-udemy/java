package org.bo.webapp.servlet.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImpl implements LoginService {
  @Override
  public Optional<String> getUsername(HttpServletRequest req) {
    HttpSession session = req.getSession();
    String username = (String) session.getAttribute("username");
    if (username == null) return Optional.empty();
    return Optional.of(username);
  }
}
