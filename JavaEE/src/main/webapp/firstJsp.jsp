<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>First JSP</title>
    </head>
    <body>
        <h1>First JSP</h1>
        <p>
            <%
                java.util.Date now = new java.util.Date();
                String someString = "Текущая дата : " + now;
             %>
            <%= someString %> <%-- Процент-равно: Нужно вернуть строку из кода --%>
        </p>
    </body>
</html>
