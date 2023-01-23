package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.bo.webapp.servlet.services.LoginService;
import org.bo.webapp.servlet.services.LoginServiceCookieImpl;
import org.bo.webapp.servlet.services.LoginServiceSessionImpl;

import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService auth = new LoginServiceSessionImpl();
    var optional = auth.getUsername(req);

    if (optional.isPresent()) {
      HttpSession session = req.getSession();
//      session.removeAttribute("username");
      session.invalidate();
    }
    resp.sendRedirect(req.getContextPath() + "/login.html");
  }
}
