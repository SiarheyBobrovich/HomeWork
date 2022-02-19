<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Jsp4</title>
    </head>
    <body>
        <h1>Hello JSP Page</h1>
        <p>
             <%-- Процент-равно: Нужно вернуть строку из кода --%>

            <%=
                "Hello, " + request.getParameter("name") + " " + request.getParameter("surname")
            %>
        </p>
    </body>
</html>
