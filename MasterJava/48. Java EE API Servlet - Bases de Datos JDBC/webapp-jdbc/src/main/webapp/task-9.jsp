<%@ page import="java.util.List" %>
<%@ page import="org.bo.webapp.servlet.models.Course" %><%--
  Created by IntelliJ IDEA.
  User: santihs
  Date: 30/1/23
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Course> courses = (List<Course>) request.getAttribute("courses");
%>
<html>
<head>
  <title>Task 9</title>
</head>
<body>
<h1>Task 9: Courses list</h1>
<form action="/webapp-jdbc/task-9" method="get">
  <div>
    <input type="text" name="filter" id="filter" placeholder="Search by name">
  </div>

  <div>
    <input type="submit" value="Search">
  </div>
</form>
<table>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Instructor</th>
    <th>Duration</th>
  </tr>
  <%
    for (Course course : courses) {
  %>
  <tr>
    <td><%=course.getId()%>
    </td>
    <td><%=course.getName()%>
    </td>
    <td><%=course.getInstructor()%>
    </td>
    <td><%=course.getDuration()%>
    </td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
