package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.bo.webapp.servlet.services.LoginService;
import org.bo.webapp.servlet.services.LoginServiceCookieImpl;
import org.bo.webapp.servlet.services.LoginServiceSessionImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
  static final String USERNAME = "admin";
  static final String PASSWORD = "1234";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (USERNAME.equals(username) && PASSWORD.equals(password)) {
      HttpSession session = req.getSession();
      session.setAttribute("username", username);

      resp.sendRedirect(req.getContextPath() + "/login.html");
    } else {
//      resp.sendStatus(HttpServletResponse.SC_UNAUTHORIZED);
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The user is not authorized to use this page");
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    LoginService auth = new LoginServiceSessionImpl();
    var optional = auth.getUsername(req);

    if (optional.isPresent()) {
      var session = optional.get();

      resp.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("     <meta charset=\"UTF-9\">");
        out.println("     <title>Hello " + session + "</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h1>Login</h1>");

        out.println("<h1>Hello " + session + " has already logged in</h1>");
        out.println("<p><a href=\"" + req.getContextPath() + "/index.html\">Go to index</a></p>");
        out.println("<p><a href=\"" + req.getContextPath() + "/logout\">Log out</a></p>");

        out.println("  </body>");
        out.println("</html>");
      }
    } else {
      getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }
  }
}
