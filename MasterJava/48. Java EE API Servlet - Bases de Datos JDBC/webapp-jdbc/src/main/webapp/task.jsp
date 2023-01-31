<%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 23/1/23
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
%>
<html>
<head>
  <title>Task 5 http</title>
</head>
<body>
<h1>Task 5: Session HTTP</h1>
<p>Hello <%= session.getAttribute("username") != null ? session.getAttribute("username") : "Anonymous" %>
<form action="/webapp-session/task" method="post">
  <div>
    <label for="username">Put the username</label>
    <div>
      <input type="text" name="username" id="username">
    </div>
  </div>
  <div>
    <input type="submit" value="Send">
  </div>
</form>
</p>
</body>
</html>
