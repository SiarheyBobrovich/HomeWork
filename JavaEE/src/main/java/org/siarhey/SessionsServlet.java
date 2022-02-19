package org.siarhey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Получаем сессию
        HttpSession session = req.getSession();

        //Получаем значение "count" из сессии
        Integer count = (Integer)session.getAttribute("count");

        //Если пользователь зашел первый раз то выставляем "count"
        //Иначе увеличиваем count на 1
        count = count == null ? 1 : count + 1;

        //Устанавливаем сессии новый параметр count
        session.setAttribute("count", count);

        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<h1>");

        writer.println("Your count is: " + count);

        writer.println("</h1>");
        writer.println("</html>");
    }
}
