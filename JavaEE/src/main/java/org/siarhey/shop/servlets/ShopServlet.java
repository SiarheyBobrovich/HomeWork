package org.siarhey.shop.servlets;

import org.siarhey.shop.dto.Cart;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Получаем сессию
        HttpSession session = req.getSession();

        if (Objects.isNull(session.getAttribute("current_user"))){
            requestRegistration(req, resp);

        }else {
            req.getRequestDispatcher("/showCart").forward(req, resp);
        }

    }

    private void requestRegistration(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/registration?name=Boy&quantity=1");
    }
}
