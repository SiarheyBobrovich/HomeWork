package org.siarhey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/postgres",
                    "postgres",
                    "172143");
            Statement statement = conn.createStatement()) {

            ResultSet rs = statement.executeQuery("SELECT * FROM books");

            while (rs.next()) {
                writer.println(rs.getSQLXML(1).getString() + "\t"
                    + rs.getSQLXML(2).getString() + "\t"
                    + rs.getSQLXML(3).getString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
