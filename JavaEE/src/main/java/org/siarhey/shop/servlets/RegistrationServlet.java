package org.siarhey.shop.servlets;


import org.siarhey.shop.dto.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        session.setAttribute("current_user", new Random().nextLong());

        Cart cart = new Cart();
        cart.setName(String.valueOf(request.getParameter("name")));
        cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        session.setAttribute("cart", cart);

        request.getRequestDispatcher("/showCart").forward(request, response);
    }
}
