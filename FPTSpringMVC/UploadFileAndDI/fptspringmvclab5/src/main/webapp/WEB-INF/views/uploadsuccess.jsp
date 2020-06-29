<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 15/05/2020
  Time: 21:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <base href="${pageContext.servletContext.contextPath}">
    <title>Upload Page</title>
</head>
<body>
<img src="<c:url value="${name}" />">
    <div>Name: ${name}</div>
    <div>Size: ${size}</div>
    <div>Type: ${type}</div>

    <form action="/">
        <button>Home</button>
    </form>
</body>
</html>
