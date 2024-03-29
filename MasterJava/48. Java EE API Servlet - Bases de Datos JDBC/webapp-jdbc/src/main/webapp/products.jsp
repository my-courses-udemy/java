<%@ page import="org.bo.webapp.servlet.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Optional" %><%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 27/1/23
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Product> products = (List<Product>) request.getAttribute("products");
  Optional<String> username = (Optional<String>) request.getAttribute("optional");
%>
<html>
<head>
  <title>Products</title>
</head>
<body>
<h1>Products list</h1>
<%
  if (username.isPresent()) {
%>
<h1>Welcome <%=username.get()%>
</h1>
<%}%>
<table>
  <tr>
    <th>Id</th>
    <th>name</th>
    <th>type</th>
    <%
      if (username.isPresent()) {
    %>
    <th>price</th>
    <th>Add</th>
    <%
      }
    %>
  </tr>
  <%
    for (Product product : products) {
  %>
  <tr>
    <td><%=product.getId()%>
    </td>
    <td><%=product.getName()%>
    </td>
    <td><%=product.getType()%>
    </td>
    <%
      if (username.isPresent()) {
    %>
    <td><%=product.getPrice()%>
    </td>
    <td><a href="<%=request.getContextPath() + "/add-cart?id=" + product.getId()%>"
    >
      Add to cart</a>
    </td>
    <%
      }
    %>
  </tr>
  <% } %>
</table>
<a href="/webapp-jdbc/see-cart">See cart</a>
</body>
</html>
