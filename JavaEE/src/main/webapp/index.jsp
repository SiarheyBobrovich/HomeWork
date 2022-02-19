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
            <p><a href="/hello-world"> FirstServlet </a></p>
            <p><a href="/hello?name=Siarhey&surname=Bobrovich"> HelloServlet </a></p>
            <p><a href="/hello-world-jsp"> firstJsp </a></p>
            <p><a href="/secondJsp.jsp"> secondJsp </a></p>
            <p><a href="/thirdJsp.jsp"> thirdJsp </a></p>
            <p><a href="/helloJsp?name=Siarhey&surname=Bobrovich"> jsp4 </a></p>
            <p><a href="/helloJsp?name=Siarhey&surname=Bobrovich"> jsp4 </a></p>
    </body>
</html>