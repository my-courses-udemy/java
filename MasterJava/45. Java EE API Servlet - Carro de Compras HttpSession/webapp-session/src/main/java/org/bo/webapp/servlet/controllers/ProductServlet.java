package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Product;
import org.bo.webapp.servlet.services.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet({"/products.html", "/products"})
public class ProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductService service = new ProductServiceImpl();
    List<Product> products = service.getList();

    LoginService auth = new LoginServiceSessionImpl();
    var optional = auth.getUsername(req);

    resp.setContentType("text/html; charset=UTF-8");
    String servletPath = req.getServletPath();

    try (PrintWriter out = resp.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("  <head>");
      out.println("     <meta charset=\"UTF-8\">");
      out.println("     <title>Products listed</title>");
      out.println("  </head>");
      out.println("  <body>");
      out.println("<h1>Products listed</h1>");
      optional.ifPresent(session -> out.println("<h2>Hello " + session + ", welcome to the products</h2>"));

      out.println("<table>");
      out.println("<tr>");
      out.println("<th>id</th>");
      out.println("<th>name</th>");
      out.println("<th>type</th>");
      if (optional.isPresent()) {
        out.println("<th>price</th>");
        out.println("<th>Add to Cart</th>");
      }
      out.println("</tr>");

      products.forEach(product -> {
        out.println("<tr>");
        out.println("<td>" + product.getId() + "</td>");
        out.println("<td>" + product.getName() + "</td>");
        out.println("<td>" + product.getType() + "</td>");
        if (optional.isPresent()) {
          out.println("<td>" + product.getPrice() + "</td>");
          out.println("<td><a href=\"" + req.getContextPath()
                  + "/add-cart?id=" + product.getId() + "\">Add Product</a></td>");
        }
        out.println("</tr>");
      });

      out.println("</table>");
      out.println("<a href=\"/webapp-session/see-cart\">See cart</a>");
      out.println("  </body>");
      out.println("</html>");
    }
  }
}
