<%@ page import="org.bo.webapp.servlet.models.Cart" %>
<%@ page import="org.bo.webapp.servlet.models.ItemCart" %><%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 24/1/23
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
  Cart cart = (Cart) session.getAttribute("cart");
%>

<html>
<head>
  <title>Cart</title>
</head>
<body>
<h1>Cart</h1>
<%
  if (cart.getItems().isEmpty()) {
%>
<p>There is no products in the cart</p>
<%
} else {
%>
<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
  </tr>
  <%
    for (ItemCart item : cart.getItems()) {
  %>
  <tr>
    <td>
      <%=item.getProduct().getId()%>
    </td>
    <td>
      <%=item.getProduct().getName()%>
    </td>
    <td>
      <%=item.getProduct().getPrice()%>
    </td>
    <td>
      <%=item.getQuantity()%>
    </td>
    <td>
      <%=item.getTotal()%>
    </td>
  </tr>
  <%
    }
  %>
  <tr>
    <td colspan="4" style="text-align: right">Total</td>
    <td>
      <%=cart.getTotal()%>
    </td>
  </tr>
</table>
<%
  }
%>
<p><a href="<%=request.getContextPath()%>/products">Continue shopping</a></p>
<p><a href="<%=request.getContextPath()%>/index.html">Go back index page</a></p>
</body>
</html>
