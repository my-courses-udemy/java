package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.services.LoginService;
import org.bo.webapp.servlet.services.LoginServiceImpl;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService auth = new LoginServiceImpl();
    var optional = auth.getUsername(req);

    if (optional.isPresent()) {
      Cookie usernameCookie = new Cookie("username", "");
      usernameCookie.setMaxAge(0);
      resp.addCookie(usernameCookie);
    }
    resp.sendRedirect(req.getContextPath() + "/login.html");
  }
}
