package org.bo.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

@WebServlet("/task")
public class IndexServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    String lastname = req.getParameter("lastname");

    PrintWriter out = resp.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("  <head>");
    out.println("     <meta charset=\"UTF-8\">");
    out.println("     <title>Servlet</title>");
    out.println("  </head>");
    out.println("  <body>");
    if (name != null && lastname != null) {
      out.println("     <h1>Hi, my name is: " + name + " " + lastname + "</h1>");
    } else {
      out.println("The data does not exist");
    }
    LocalDate date = LocalDate.now();
    out.println("<h2>The current data is: " +
            date.getMonth().getDisplayName(TextStyle.FULL, new Locale("en", "EN")) + " "
            + date.getDayOfMonth() + ", " + date.getYear() + " </h2>");
    out.println("  </body>");
    out.println("</html>");
    out.close();
  }
}
