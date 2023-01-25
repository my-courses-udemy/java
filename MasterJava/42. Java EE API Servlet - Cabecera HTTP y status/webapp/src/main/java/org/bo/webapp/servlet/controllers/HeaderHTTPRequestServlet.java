package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/header-request")
public class HeaderHTTPRequestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");

    String methodHttp = req.getMethod();
    String requestURI = req.getRequestURI();
    String requestURL = req.getRequestURL().toString();
    String contextPath = req.getContextPath();
    String servletPath = req.getServletPath();
    String ipClient = req.getRemoteAddr();
    String ip = req.getLocalAddr();
    int port = req.getLocalPort();
    String scheme = req.getScheme();
    String host = req.getHeader("host");
    String url = scheme + "://" + host + contextPath + servletPath;
    String url2 = scheme + "://" + ip + ":" + port + contextPath + servletPath;

    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head>");
      out.println("     <meta charset=\"UTF-8\">");
      out.println("     <title>Header HTTP</title>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("<h1>Header HTTP request</h1>");
      out.println("<ul>");
      out.println("<li>Http method: " + methodHttp + "</li>");
      out.println("<li>Request URI: " + requestURI + "</li>");
      out.println("<li>Request URL: " + requestURL + "</li>");
      out.println("<li>Context path: " + contextPath + "</li>");
      out.println("<li>Servlet path: " + servletPath + "</li>");
      out.println("<li>Local IP: " + ip + "</li>");
      out.println("<li>Local IP client: " + ipClient + "</li>");
      out.println("<li>Local Port: " + port + "</li>");
      out.println("<li>Scheme: " + scheme + "</li>");
      out.println("<li>Host: " + host + "</li>");
      out.println("<li>URL CREATED: " + url + "</li>");
      out.println("<li>URL2 CREATED: " + url2 + "</li>");
      out.println("<br>");

      Enumeration<String> headerNames = req.getHeaderNames();
      while (headerNames.hasMoreElements()) {
        String header = headerNames.nextElement();
        out.println("<li>" + header + ": " + req.getHeader(header) + "</li>");
      }

      out.println("<br>");
      out.println("</ul>");
      out.println("  </body>");
      out.println("</html>");
    }
  }
}
