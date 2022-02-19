package org.siarhey;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        String name = httpServletRequest.getParameter("name");
        String surname = httpServletRequest.getParameter("surname");

        PrintWriter writer = httpServletResponse.getWriter();

        writer.println("<html>");
        writer.println("<h1>");

        writer.println("Hello " + name + " " + surname + ".");

        writer.println("</h1>");
        writer.println("</html>");
    }
}
