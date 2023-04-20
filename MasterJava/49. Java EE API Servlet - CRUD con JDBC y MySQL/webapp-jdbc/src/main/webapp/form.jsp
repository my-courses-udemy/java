<%@ page import="java.util.List" %>
<%@ page import="org.bo.webapp.servlet.models.Category" %>
<%@ page import="java.util.Map" %>
<%@ page import="org.bo.webapp.servlet.models.Product" %>
<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 31/1/23
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Category> categories = (List<Category>) request.getAttribute("categories");
  Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
  Product product = (Product) request.getAttribute("product");

  String date = (product.getRegisterDate() != null)
      ? product.getRegisterDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
      : "";
%>
<html>
<head>
  <title>Product Form</title>
</head>
<body>
<h1>Product Form</h1>
<form action="<%=request.getContextPath() + "/product-form"%>" method="post">
  <div>
    <label for="name">Name</label>
    <div>
      <input type="text" name="name" id="name" placeholder="name"
             value="<%=product.getName()!=null ? product.getName() : "" %>">
    </div>
    <% if (errors != null && errors.containsKey("name")) { %>
    <p style="color: red;">
      <%=errors.get("name")  %>
    </p>
    <%}%>
  </div>
  <div>
    <label for="price">Price</label>
    <div>
      <input type="number" name="price" id="price" placeholder="price"
             value="<%=product.getPrice()!=0 ? product.getPrice() : ""%>">
    </div>
    <% if (errors != null && errors.containsKey("price")) { %>
    <p style="color: red;">
      <%=errors.get("price")  %>
    </p>
    <%}%>
  </div>
  <div>
    <label for="sku">Sku</label>
    <div>
      <input type="text" name="sku" id="sku" placeholder="sku"
             value="<%=product.getSku()!=null ? product.getSku() : ""%>">
    </div>
    <% if (errors != null && errors.containsKey("sku")) { %>
    <p style="color: red;">
      <%=errors.get("sku")  %>
    </p>
    <%}%>
  </div>
  <div>
    <label for="register_date">Register Date</label>
    <div>
      <input type="date" name="register_date" id="register_date" placeholder="register_date"
             value="<%=date%>">
    </div>
    <% if (errors != null && errors.containsKey("register_date")) { %>
    <p style="color: red;">
      <%=errors.get("register_date")  %>
    </p>
    <%}%>
  </div>
  <div>
    <label for="category"></label>
    <div>
      <select name="category" id="category">
        <option value="">-- Select --</option>
        <%
          for (Category category : categories) {
        %>
        <option
            value="<%=category.getId()%>"
            <%=category.getId().equals(product.getCategory().getId()) ? "selected" : ""%>
        >
          <%=category.getName()%>
        </option>
        <%
          }
        %>
      </select>
    </div>
    <% if (errors != null && errors.containsKey("category")) { %>
    <p style="color: red;">
      <%=errors.get("category")  %>
    </p>
    <%}%>
  </div>
  <div>
    <input type="submit" value="<%=product.getId()!=null ? "Edit Product": "Create product"%>">
  </div>
  <input type="hidden" name="id" value="<%=product.getId()%>">
</form>
</body>
</html>
