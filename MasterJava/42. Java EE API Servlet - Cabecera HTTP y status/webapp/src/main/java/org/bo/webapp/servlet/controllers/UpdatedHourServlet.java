package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/updated-hour")
public class UpdatedHourServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    resp.setContentType("text/html;charset=UTF-8");
    resp.setHeader("refresh", "1");

    LocalTime hour = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head>");
      out.println("     <meta charset=\"UTF-8\">");
      out.println("     <title>Updated hour</title>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("<h1>Updated hour</h1>");

      out.println("<h2>" + hour.format(formatter) + "</h2>");

      out.println("  </body>");
      out.println("</html>");
    }
  }
}
