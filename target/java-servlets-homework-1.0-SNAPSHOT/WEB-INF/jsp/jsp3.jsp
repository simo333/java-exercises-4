<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="mvc13" method="post">
    Title: <input type="text" name="title" value="${titleField}"><br>
    <c:if test="${not empty errors['titleError']}"><span style="color:red">${errors['titleError']}</span><br></c:if>
    Author: <input type="text" name="author" value="${authorField}"><br>
    <c:if test="${not empty errors['authorError']}"><span style="color:red">${errors['authorError']}</span><br></c:if>
    ISBN: <input type="text" name="isbn" value="${isbnField}"><br>
    <c:if test="${not empty errors['isbnError']}"><span style="color:red">${errors['isbnError']}</span><br></c:if>
    <input type="submit">

</form>
</body>
</html>
