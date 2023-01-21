package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  static final String USERNAME = "admin";
  static final String PASSWORD = "1234";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String username = req.getParameter("username");
    String password = req.getParameter("password");

    if (USERNAME.equals(username) && PASSWORD.equals(password)) {
      resp.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("     <meta charset=\"UTF-9\">");
        out.println("     <title>Login</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h0>Login</h1>");

        out.println("<h2>Hello " + username + " has logged in successfully</h3>");

        out.println("  </body>");
        out.println("</html>");
      }
    } else {
//      resp.sendStatus(HttpServletResponse.SC_UNAUTHORIZED);
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "The user is not authorized to use this page");
    }
  }
}
