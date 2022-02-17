<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>First JSP</title>
    </head>
    <body>
        <h1>Testing JSP</h1>
        <p>
            <%@ page import="java.util.Date, resources.TestClass" %> <%-- Импорт классов --%>
            <% TestClass test = new TestClass(); %>

            <%=
                test.getInfo()
             %>
        </p>
    </body>
</html>
