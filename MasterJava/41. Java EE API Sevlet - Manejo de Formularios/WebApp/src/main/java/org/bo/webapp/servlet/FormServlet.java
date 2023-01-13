package org.bo.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/register")
public class FormServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");

    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String email = req.getParameter("email");
    String country = req.getParameter("country");
    String[] languages = req.getParameterValues("languages");
    String[] roles = req.getParameterValues("roles");
    String idioms = req.getParameter("idioms");
    String enable = req.getParameter("enable");

    Map<String, String> errors = new HashMap<>();

    if (username.trim().isEmpty()) {
      errors.put("username", "The username is empty");
    }
    if (password.trim().isEmpty()) {
      errors.put("password", "The password is empty");
    }
    if (email.trim().isEmpty()) {
      errors.put("email", "The email is empty");
    }

    if (errors.isEmpty()) {
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("     <meta charset=\"UTF-8\">");
        out.println("     <title>Servlet</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("     <h1>Hello world from servlet</h1>");
        out.println("     <ul>");
        out.println("       <li>Username: " + username + "</li>");
        out.println("       <li>Password: " + password + "</li>");
        out.println("       <li>Email: " + email + "</li>");
        out.println("     </ul>");
        out.println("     <h1>Country: </h1>");
        out.println("       <p>" + country + "</p>");
        out.println("     <h1>Languages</h1>");
        out.println("     <ul>");
        for (String language : languages) {
          out.println("       <li>Languages: " + language + "</li>");
        }
        out.println("     </ul>");
        out.println("     <h1>Roles</h1>");
        out.println("     <ul>");
        for (String rol : roles) {
          out.println("       <li>Rol: " + rol + "</li>");
        }
        out.println("     </ul>");
        out.println("     <h1>idioms</h1>");
        out.println("       <p>" + idioms + "</p>");
        out.println("     <h1>enable</h1>");
        out.println("       <p>" + enable + "</p>");
        out.println("  </body>");
        out.println("</html>");
      }
    } else {
      req.setAttribute("errors", errors);
      req.getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
  }
}
