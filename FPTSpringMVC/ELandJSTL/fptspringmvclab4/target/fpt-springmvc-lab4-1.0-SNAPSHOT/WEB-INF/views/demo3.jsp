<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 13/05/2020
  Time: 23:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Demo 3</title>
</head>
<body>
    <h1>Demo 3</h1>
    <li>Tên: ${student.name}</li>
    <li>Điểm: ${student.point}</li>
    <div>c:if</div>
    <c:if test="${student.point > 5}">
            <li>Điểm trên trung bình</li>
    </c:if>
    <div>c:choose</div>
    <li>
        <c:choose>
            <c:when test="${student.point > 8}">HS Giỏi</c:when>
            <c:when test="${student.point > 6.5}">HS Khá</c:when>
            <c:when test="${student.point < 4}">Kém</c:when>
            <c:otherwise>Trung Bình</c:otherwise>
        </c:choose>
    </li>
    <div>c:foreach</div>
    <c:forEach var="st" items="${students}" begin="0" end="2" varStatus="status">
        <li>
            <div>Vị trí: ${status.index}</div>
            <div>Tên: ${st.name}</div>
        </li>
    </c:forEach>
    <form action="/">
        <button>Back To Home</button>
    </form>
</body>
</html>
