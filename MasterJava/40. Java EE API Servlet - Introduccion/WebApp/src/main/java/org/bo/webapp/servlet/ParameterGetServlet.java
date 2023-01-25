package org.bo.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parameter/url-get")
public class ParameterGetServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");

    String greeting = req.getParameter("greeting");
    String name = req.getParameter("name");

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("  <head>");
    out.println("     <meta charset=\"UTF-8\">");
    out.println("     <title>Servlet with parameter</title>");
    out.println("  </head>");
    out.println("  <body>");
    out.println("     <h1>Hello world from servlet</h1>");

    if (greeting != null && name != null) {
      out.println("     <h2>Hi " + greeting + " " + name + "</h2>");
    } else if (greeting != null) {
      out.println("     <h2>The greeting is: " + greeting + "</h2>");
    } else if (name != null) {
      out.println("     <h2>The name is: " + name + "</h2>");
    }
    try {
      Integer code = Integer.parseInt(req.getParameter("code"));
      out.println("<h3>The code sent is: " + code + "</h3>");
    } catch (NumberFormatException e) {
      out.println(e.getMessage());
    }
    out.println("</html>");
    out.close();
  }
}
