<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SimoPc
  Date: 29.05.2022
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${book.title.length() == 0 || book.author.length() == 0 || book.isbn.length() == 0}">
        Brak danych
    </c:when>
    <c:otherwise>
        Title: ${book.title} <br>
        Author: ${book.author} <br>
        ISBN: ${book.isbn} <br>
    </c:otherwise>
</c:choose>

</body>
</html>
