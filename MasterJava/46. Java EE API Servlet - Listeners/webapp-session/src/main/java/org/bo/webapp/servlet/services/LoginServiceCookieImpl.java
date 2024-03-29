package org.bo.webapp.servlet.services;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceCookieImpl implements LoginService {
  @Override
  public Optional<String> getUsername(HttpServletRequest req) {
    Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
    return Arrays.stream(cookies)
            .filter(cookie -> cookie.getName().equals("username"))
            .map(Cookie::getValue)
            .findFirst();
  }
}
