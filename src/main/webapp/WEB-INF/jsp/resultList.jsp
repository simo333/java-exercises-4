<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="book" items="${books}">
    Title: ${book.title} <br>
    Author: ${book.author} <br>
    ISBN: ${book.isbn} <br><hr>
</c:forEach>
</body>
</html>
