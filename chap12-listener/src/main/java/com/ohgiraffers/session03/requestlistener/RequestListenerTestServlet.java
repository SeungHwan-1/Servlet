package com.ohgiraffers.session03.requestlistener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/request")
public class RequestListenerTestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("username", "honggildong");
        request.setAttribute("age", 20);
        request.setAttribute("gender", "M");


        request.setAttribute("username", "hong");


        request.removeAttribute("gender");

    }
}
