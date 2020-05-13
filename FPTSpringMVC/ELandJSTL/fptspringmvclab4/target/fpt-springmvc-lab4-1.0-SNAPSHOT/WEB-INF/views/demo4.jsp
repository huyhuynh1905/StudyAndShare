<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 13/05/2020
  Time: 23:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Demo 4</title>
</head>
<body>
    <h1>Demo 4</h1>
    <div> c:set </div>
    <c:set var="cset" value="Gán Bằng c:set" scope="session"/>
    <div>Nội dung: ${cset}</div>
    <form action="/">
        <button>Back To Home</button>
    </form>
</body>
</html>
