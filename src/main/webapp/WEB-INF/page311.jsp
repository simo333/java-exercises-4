<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SimoPc
  Date: 06.06.2022
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<c:url value="/servlet312"/>" method="post">
    <c:choose>
        <c:when test="${not empty cookie.lang}">
            <p>${cookie.lang.value}</p>
        </c:when>
        <c:otherwise>
            <p>${msg}</p>
        </c:otherwise>
    </c:choose>

    <label for="lang">Choose language:</label>
    <select name="lang" id="lang">
        <option value="pl">polski</option>
        <option value="en">english</option>
        <option value="de">deutsch</option>
        <option value="es">español</option>
        <option value="fr">français</option>
    </select>
    <input type="submit" value="OK">
</form>

</body>
</html>
