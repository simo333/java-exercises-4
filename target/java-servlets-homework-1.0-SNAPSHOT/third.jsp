<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${empty param.a ? "BRAK" : param.a}
<br>
${empty param.b ? "BRAK" : param.b}
<br>
${empty (param.a && param.b) ? "BRAK" : param.a.concat(" ").concat(param.b)}
</body>
</html>
