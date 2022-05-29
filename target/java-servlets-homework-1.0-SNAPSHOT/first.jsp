<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Kilometry: ${param.km}
<br>
Test: ${empty param.km ? "BRAK" : param.km}
<br>
Mile: ${param.km * 0.62}
</body>
</html>
