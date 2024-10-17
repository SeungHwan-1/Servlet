package com.ohgiraffers.section01.forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = (String)req.getAttribute("userId");
        System.out.println(userId);

        String userId2 = req.getParameter("userId");
        System.out.println(userId2);

        // 응답에 필요한 데이터가 준비되면 동적인 웹 페이지를 생성한다..
        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>")
        .append("<html>\n")
        .append("<head>\n")
        .append("</head>\n")
        .append("<body>\n")
        .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다</h3>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();

        out.print(responseText);
        out.flush();
        out.close();


        /*
        * 기본적으로 변수의 기본 스코프는 메소드 이기 때문에
        * 다른페이지(서블릿)으로 데이터를 공유할 수 없다..
        * 하지만 forward 방식은 request 와 response를 포함하여 위임하므로
        * 위임한 서블릿의 정보를 받을 수 있다..
        * forward 받은 서블릿의 존재를 클라이언트가 알 필요가 없기 때문에
        * url 자체는 변경되지 않는다..
        * forward 방식의 또 다른 특징은 요청 시 서버로 전송한 데이터가
        * 남아있는 상태로 새로고침(재요청)을 하면 동일한 요청을 반복하여
        * 데이터베이스에 insert 하는 등의 행위등이 중복된 행이 삽입될 가능성이 있다.
        * 따라서 그런 경우는 다른 페이지 전환 방식인 redirect를 이용한다.
         */


    }
}
