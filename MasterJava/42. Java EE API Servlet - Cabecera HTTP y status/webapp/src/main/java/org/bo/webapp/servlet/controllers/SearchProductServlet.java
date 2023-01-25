package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.services.ProductService;
import org.bo.webapp.servlet.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search-product")
public class SearchProductServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductService service = new ProductServiceImpl();
    String name = req.getParameter("product");

    var optional = service.searchProduct(name);
    if (optional.isPresent()) {
      resp.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = resp.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("     <meta charset=\"UTF-8\">");
        out.println("     <title>Search Product</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h1>Search Product</h1>");

        out.println("<h3>Product name: " + optional.get().getName() + "</h3>");
        out.println("<h3>Product price: " + optional.get().getPrice() + "</h3>");

        out.println("  </body>");
        out.println("</html>");
      }
    } else {
      resp.sendError(HttpServletResponse.SC_NOT_FOUND, "The product " + name + " is not available");
    }
  }
}
