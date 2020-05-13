<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 13/05/2020
  Time: 22:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2</title>
</head>
<body>
    <h1>Demo 2</h1>
    <li>Object name: ${student.name}</li>
    <li>Object point: ${student.point}</li>
    <li>List String item 1: ${list[0]}</li>
    <li>List String item 2: ${list[1]}</li>
    <li>Map Name: ${mapST.name}</li>
    <li>Map point: ${mapST.point}</li>
    <form action="/">
        <button>Back To Home</button>
    </form>
</body>
</html>
