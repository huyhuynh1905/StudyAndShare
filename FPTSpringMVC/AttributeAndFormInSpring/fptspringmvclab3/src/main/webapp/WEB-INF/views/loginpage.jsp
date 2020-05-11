<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 10/05/2020
  Time: 23:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <%--@elvariable id="student" type="com.huyhuynh.models"--%>
    <form:form action="/login" modelAttribute="student">
        <div>ID: </div>
        <form:input path="user"/>
        <div>Pass: </div>
        <form:input path="pass"/>
        <button>Login</button>
    </form:form>
</body>
</html>
