<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 13/05/2020
  Time: 21:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo EL</title>
</head>
<body>
    <h1>Demo 1</h1>
    <li>name: ${name}</li>
    <li>age: ${age}</li>
    <li>sessionScope: ${sessionScope.name}</li>
    <li>sessionScope: ${sessionScope.age}</li>
    <li>requestScope: ${requestScope.name}</li>
    <li>requestScope: ${requestScope.age}</li>
    <form action="/">
        <button>Back To Home</button>
    </form>
</body>
</html>
