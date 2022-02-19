<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>ShowCart</title>
    </head>
    <body>
        <h1>ShowCart</h1>
        <p>
            <%@ page import="org.siarhey.shop.dto.Cart" %>

            <% Cart cart = (Cart)session.getAttribute("cart"); %>
        </p>
        <p>
            <%="Наименование: " + cart.getName() %>
        </p>
        <p>
            <%="Колличество: " + cart.getQuantity() %>
        </p>
        <p>
            <%="Текущая сессия: " + session.getAttribute("current_user") %>
        </p>

    </body>
</html>
