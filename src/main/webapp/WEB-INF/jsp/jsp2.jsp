<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty message}">
        ${message}
    </c:when>
    <c:otherwise>
        <c:forEach begin="${start}" end="${end}" var="number">
            ${number}
        </c:forEach>
    </c:otherwise>
</c:choose>
</body>
</html>
