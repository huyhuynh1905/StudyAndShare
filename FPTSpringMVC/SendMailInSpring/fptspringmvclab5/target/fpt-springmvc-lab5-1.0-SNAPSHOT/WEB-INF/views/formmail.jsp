<%--
  Created by IntelliJ IDEA.
  User: huyhu
  Date: 30/06/2020
  Time: 15:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Email</title>
</head>
<body>
    ${message}
    <form action="/mail/send" method="post">
        <p><input name="from" placeholder="From"></p>
        <p><input name="to" placeholder="To"></p>
        <p><input name="subject" placeholder="Subject"></p>
        <p><textarea name="body" placeholder="body" rows="3" cols="30"></textarea></p>
        <p><button>Send</button></p>
    </form>
</body>
</html>
