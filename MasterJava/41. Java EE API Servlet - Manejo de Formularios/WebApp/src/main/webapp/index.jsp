<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%
  Map<String, String> errors = (Map<String, String>) request.getAttribute("errors");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Java EE</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1 class="display-1 text-center">Formulary</h1>
<%
  if (errors != null && !errors.isEmpty()) {
%>
<ul>
  <%
    for (String error : errors.values()) {
  %>
  <li><%=error%>
  </li>
  <%
    }
  %>
</ul>
<%
  }
%>
<form action="/WebApp/register" method="post" class="form p-5">
  <div class="row mb-3">
    <label class="col-form-label col-sm-2" for="username">Username</label>
    <div class="col-sm-4"><input class="form-control" type="text" name="username" id="username"></div>
    <%
      if (errors != null && errors.containsKey("username")) {
    %>
    <small style="color: red"><%=errors.get("username")%>
    </small>
    <%
      }
    %>
  </div>
  <div class="row mb-3">
    <label class="col-form-label col-sm-2" for="password">Password</label>
    <div class="col-sm-4"><input class="form-control" type="password" name="password" id="password"></div>
    <%
      if (errors != null && errors.containsKey("password")) {
    %>
    <small style="color: red"><%=errors.get("password")%>
    </small>
    <%
      }
    %>
  </div>
  <div class="row mb-3">
    <label class="col-form-label col-sm-2" for="email">Email</label>
    <div class="col-sm-4"><input class="form-control" type="email" name="email" id="email"></div>
    <%
      if (errors != null && errors.containsKey("email")) {
    %>
    <small style="color: red"><%=errors.get("email")%>
    </small>
    <%
      }
    %>
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2" for="country">Countries</label>
    <div class="row mb-3">
      <select class="form-select" name="country" id="country">
        <option value="">-- Select</option>
        <option value="chile">Chile</option>
        <option value="argentina">Argentina</option>
        <option value="peru">Peru</option>
        <option value="mexico">Mexico</option>
        <option value="spain">Spain</option>
      </select>
    </div>
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2" for="languages">Languages</label>
    <div class="row mb-3">
      <select class="form-select" name="languages" id="languages" multiple>
        <option value="java">Java</option>
        <option value="jakarta">Jakarta EE 9</option>
        <option value="python">Python</option>
        <option value="javascript">Javascript</option>
      </select>
    </div>
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Roles</label>
    <div class="row mb-3">
      <input class="form-control" type="checkbox" name="roles" value="ADMIN_ROL">
      <label class="col-form-label col-sm-2">Admin</label>
    </div>
    <div class="row mb-3">
      <input class="form-control" type="checkbox" name="roles" value="USER_ROL">
      <label class="col-form-label col-sm-2">User</label>
    </div>
    <div class="row mb-3">
      <input class="form-control" type="checkbox" name="roles" value="MOD_ROL">
      <label class="col-form-label col-sm-2">Moderator</label>
    </div>
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Languages</label>
    <div class="row mb-3">
      <input class="form-control" type="radio" name="idioms" id="es" value="es">
      <label class="col-form-label col-sm-2">Spain</label>
    </div>
    <div class="row mb-3">
      <input class="form-control" type="radio" name="idioms" id="en" value="en">
      <label class="col-form-label col-sm-2">English</label>
    </div>
    <div class="row mb-3">
      <input class="form-control" type="radio" name="idioms" id="fr" value="fr">
      <label class="col-form-label col-sm-2">French</label>
    </div>
  </div>

  <div class="row mb-3">
    <label class="col-form-label col-sm-2">Enable</label>
    <div class="row mb-3">
      <input class="form-control" type="checkbox" name="enable" id="enable" checked>
    </div>
  </div>

  <div class="row mb-3">
    <input class="btn btn-primary" type="submit" value="Sent">
  </div>
</form>
</body>
</html>