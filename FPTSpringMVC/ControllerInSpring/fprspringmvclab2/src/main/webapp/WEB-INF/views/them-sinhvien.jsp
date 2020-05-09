<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 09/05/2020
  Time: 21:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them SV</title>
</head>
<body>
    <h1>Thêm Sinh Viên Thành Công</h1>
    <div>Nhấn để tiến hành đăng nhập: </div>
    <form action="/home/login-from-them" method="get">
        <input name="id" value="${id}">
        <input name="pass" value="${pass}">
        <button>Login</button>
        <button name="btnBackHome">Quay Lai</button>
    </form>
</body>
</html>
