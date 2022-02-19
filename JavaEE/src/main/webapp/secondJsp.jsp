<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Second JSP</title>
    </head>
    <body>
        <h1>Testing JSP</h1>
        <p>
            <%
                for (int i = 0; i < 10; i++) {
                    out.println("<p>" + "Hello " + i + "</p>");
                }
            %>
        </p>
    </body>
</html>
