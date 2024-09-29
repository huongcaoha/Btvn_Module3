<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 9/27/2024
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action=<%=request.getContextPath()%>"/login" method="POST">
    ${rs ? "<h5 style='color: red'>username or password not match !</h5>" : ""}

    <h2>Login</h2>
    <input type="text" name="username" id="username" placeholder="username">
    <br>
    <input type="password" name="password" id="password" placeholder="password">
    <br>
    <input type="submit" value="Login">
</form>
</body>
</html>
