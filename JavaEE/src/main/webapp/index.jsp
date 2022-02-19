<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Main Page</title>
    </head>
    <body>
        <h1>Время запуска</h1>
        <p>
            <%
                java.util.Date now = new java.util.Date();
                String someString = "Текущая дата : " + now;
             %>
            <%= someString %> <%-- Процент-равно: Нужно вернуть строку из кода --%>
        </p>
    </body>
</html>