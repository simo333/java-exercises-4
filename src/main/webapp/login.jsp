<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3 style="color: #2255FF">${logoutMessage}</h3>
<form action="<c:url value="/login"/>" method="post">
    Username: <input type="text"  name="username"/><br>
    Password: <input name="password" type="password"/><br>
    <c:if test="${not empty valid && not valid}"><span style="color: red">Nieprawidłowe dane logowania.</span><br></c:if>
    <button type="submit">Zaloguj</button>
</form>

</body>
</html>
