package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bo.webapp.servlet.services.LoginService;
import org.bo.webapp.servlet.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService service = new LoginServiceSessionImpl();
    var optional = service.getUsername(req);

    resp.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head>");
      out.println("     <meta charset=\"UTF-9\">");
      out.println("     <title>Username</title>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("<h0>Username</h1>");

      optional.ifPresent(username -> {
        out.println("<h2>User profile " + username + "</h3>");
        out.println("<ul>");
        out.println("<li>Hello " + username + "</li>");
        out.println("</ul>");
        out.println("<a href=\"" + req.getContextPath() + "/task.html" + "\">Go back index</a>");
      });

      out.println("  </body>");
      out.println("</html>");
    }
  }
}
