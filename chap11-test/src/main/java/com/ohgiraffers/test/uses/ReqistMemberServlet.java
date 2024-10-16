package com.ohgiraffers.test.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/member/regist")
public class ReqistMemberServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String password = req.getParameter("password"); // 여기서 이미 암호화됨
        String email = req.getParameter("email");

        HttpSession session = req.getSession();
        System.out.println("session default 유지 시간 :" + session.getMaxInactiveInterval());

        session.setAttribute("userId", userId);
        session.setAttribute("password", password);
        session.setAttribute("email", email);


        resp.sendRedirect("../login.jsp");
    }
}
