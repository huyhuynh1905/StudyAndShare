<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 11/05/2020
  Time: 21:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Student</title>
</head>
<body>
    <%--@elvariable id="student" type="com.huyhuynh.models"--%>
    <form:form action="/update" modelAttribute="student">
        <div>Họ Và Tên: </div>
        <form:input path="name"/>
        <div>Tuổi</div>
        <form:input path="age"/>
        <div>Chuyên ngành</div>
        <form:select path="major" items="${majors}"/>
        <div>Chức Vụ</div>
        <form:radiobuttons path="level" items="${levels}" itemValue="id" itemLabel="name"/>
        <div>Quay Về</div>
        <button>OK</button>
    </form:form>
</body>
</html>
