package org.bo.webapp.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bo.webapp.servlet.models.Product;
import org.bo.webapp.servlet.services.*;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet({"/products.html", "/products"})
public class ProductServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Connection connection = (Connection) req.getAttribute("conn");
    ProductService service = new ProductServiceJDBCImpl(connection);
    List<Product> products = service.getList();

    LoginService auth = new LoginServiceSessionImpl();
    var optional = auth.getUsername(req);

    req.setAttribute("optional", optional);
    req.setAttribute("products", products);

    getServletContext().getRequestDispatcher("/products.jsp").forward(req, resp);
  }
}
