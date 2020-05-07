<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 07/05/2020
  Time: 23:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
${message}
<form action="/user-login" method="post">
    <div>User: </div>
    <input name="user">
    <div>Password: </div>
    <input name="pass">
    <button>Login</button>
</form>
</body>
</html>
