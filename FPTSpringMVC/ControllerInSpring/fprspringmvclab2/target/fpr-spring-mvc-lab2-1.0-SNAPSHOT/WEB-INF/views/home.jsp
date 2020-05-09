<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 09/05/2020
  Time: 21:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Dang Nhap</title>
</head>
<body>
    ${mess}
    <form action="/home/home-form" method="post">
        <div>User: </div>
        <input name="id" value="${id}"/>
        <div>Password: </div>
        <input name="pass" value="${pass}">

        <button name="btnThem">Them</button>
        <button name="btnLogin">Login</button>
    </form>
</body>
</html>
