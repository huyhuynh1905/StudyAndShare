<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 13/05/2020
  Time: 23:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Demo 5</title>
</head>
<body>
    <h1>Demo 5</h1>
    <li>Nội dung: ${mess}</li>
    <li>Hàm in hoa: ${fn:toUpperCase(mess)}</li>
    <div>Số lượng kí tự</div>
    <li>
        ${fn:length(mess)}
    </li>
    <div>Kiểm tra xem bắt đầu bằng "Xin"</div>
    <c:if test="${fn:startsWith(\"Xin\",mess)}">
        <li>Bắt đầu bằng "Xin"</li>
    </c:if>
    <div>Cắt chuỗi bằng dấu cách</div>
    <c:set var="lists" value="${fn:split(mess,\" \")}"/>
    <c:forEach var="i" items="${lists}" varStatus="status">
        <li>${i}</li>
    </c:forEach>
</body>
</html>
