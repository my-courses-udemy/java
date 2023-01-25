package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Product;
import org.bo.webapp.servlet.services.ProductService;
import org.bo.webapp.servlet.services.ProductServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet({"/products.xls", "/products.html", "/products"})
public class ProductXLSServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductService service = new ProductServiceImpl();
    List<Product> products = service.getList();

    resp.setContentType("text/html; charset=UTF-8");
    String servletPath = req.getServletPath();
    boolean isXls = servletPath.endsWith(".xls");
    if (isXls) {
      resp.setContentType("application/vnd.ms-excel");
      resp.setHeader("Content-Disposition", "attachment;filename=products.xls");
    }

    try (PrintWriter out = resp.getWriter()) {
      if (!isXls) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("  <head>");
        out.println("     <meta charset=\"UTF-8\">");
        out.println("     <title>Products listed</title>");
        out.println("  </head>");
        out.println("  <body>");
        out.println("<h1>Products listed</h1>");
        out.println("<p><a href=\"" + req.getContextPath() + "/products.xls" + "\">Export to xls</a></p>");
        out.println("<p><a href=\"" + req.getContextPath() + "/products.json" + "\">Export to json</a></p>");
      }

      out.println("<table>");
      out.println("<tr>");
      out.println("<th>id</th>");
      out.println("<th>name</th>");
      out.println("<th>type</th>");
      out.println("<th>price</th>");
      out.println("</tr>");

      products.forEach(product -> {
        out.println("<tr>");
        out.println("<td>" + product.getId() + "</td>");
        out.println("<td>" + product.getName() + "</td>");
        out.println("<td>" + product.getType() + "</td>");
        out.println("<td>" + product.getPrice() + "</td>");
        out.println("</tr>");
      });

      out.println("</table>");

      if (!isXls) {
        out.println("  </body>");
        out.println("</html>");
      }
    }
  }
}
