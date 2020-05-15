<%--
  Created by IntelliJ IDEA.
  User: HuyHuynh
  Date: 15/05/2020
  Time: 21:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.servletContext.contextPath}">
    <title>Demo Upload</title>
</head>
<body>
    ${mess}
    <form action="/upload/uploadfile" method="post" enctype="multipart/form-data">
        <div>File</div>
        <input type="file" name="image"/>
        <button>Upload</button>
    </form>
</body>
</html>
