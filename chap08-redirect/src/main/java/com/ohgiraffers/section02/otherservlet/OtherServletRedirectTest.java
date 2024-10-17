package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirect")
public class OtherServletRedirectTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("이 서블릿으로 redirect 성공");

        System.out.println(resp);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1> 이 서ㅓ블릿으로 redirect성공</h1>");
        out.flush();
        out.close();

        /*
        * redirect하면 urp이 재작성되어 새로고침할 때 redirect된 페이지에 대한 요청을 반복한다
        * 즉, 이전 요청에 포함된 정보는 남아있지 않고 url이 변경되는 것이 redirect의 특징이다
        * 첫 요청시의 request와 현재 redirect 된 페이지의 request는 서로 다른 객체 이므로
        * http 요청은 요청 시 잠시 connection 을 맺고 응답 시에도 잠시 connection을 맺으며
        * 요청 단위당 request 객체는 한 개만 생성된다.
         */
    }
}
