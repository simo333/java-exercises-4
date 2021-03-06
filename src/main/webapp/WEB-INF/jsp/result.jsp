<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${book.title.length() == 0 || book.author.length() == 0 || book.isbn.length() == 0}">
        Brak książek
    </c:when>
    <c:otherwise>
        <div style="background: darkseagreen; display: inline-block; padding: 5px;">
        Dodałeś książkę:
        Title: ${book.title} <br>
        Author: ${book.author} <br>
        ISBN: ${book.isbn} <br>
        </div>
        <a href="mvc13"><input type="button" value="Dodaj nową książkę"/></a>
    </c:otherwise>
</c:choose>

<c:if test="${not books.isEmpty()}">
    <h2>Dodane książki:</h2>
    <hr>
    <jsp:include page="resultList.jsp"/>
</c:if>
</body>
</html>
