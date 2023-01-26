<%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 26/1/23
  Time: 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  long startTime = (long) request.getAttribute("time");
  long endTime = System.nanoTime();
  double time = (endTime - startTime) / 1e6;
%>
<html>
<head>
  <title>Task 8</title>
</head>
<body>
<h1>Task 8</h1>
<p>
  The time is: <%=time%> ms
</p>
</body>
</html>
