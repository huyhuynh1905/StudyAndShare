<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 15/05/2020
  Time: 21:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo Bean</title>
</head>
<body>
    <div>${companyKMA.name}</div>
    <div>${companyKMA.slogan}</div>">
    <br>
    <div>FPT</div>
    <div>${companyFPT.name}</div>
    <div>${companyFPT.slogan}</div>
    <form action="/uploadpage">
        <button>Upload Page</button>
    </form>
</body>
</html>
