package com.alkewallet.controller;

import com.alkewallet.model.Wallet;
import com.alkewallet.service.CurrencyConverterImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/wallet")
public class WalletServlet extends HttpServlet {

    private Wallet wallet = new Wallet("CLP");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("balance", wallet.getBalance());
        request.setAttribute("currency", wallet.getCurrency());

        request.getRequestDispatcher("views/wallet.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("deposit".equals(action)) {
                double amount = Double.parseDouble(request.getParameter("amount"));
                wallet.deposit(amount);
            }

            if ("withdraw".equals(action)) {
                double amount = Double.parseDouble(request.getParameter("amount"));
                wallet.withdraw(amount);
            }

            if ("convert".equals(action)) {
                String currency = request.getParameter("currency");
                wallet.convertBalance(new CurrencyConverterImpl(), currency);
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        response.sendRedirect("wallet");
    }
}