package com.ohgiraffers.section01.contextlistener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿");

        //웹 어플리케이션의 전역 정보를 관리하는 객체.. 서버가 시작될 때 생성된다.
        // 어플리케이션에 하나만 존재한다.
        //전체에서 공통을 사용하는 데이터를 저장하거나 설정 정보를 공유할 때 사용한다..
        //잘안쓰는게 좋음 민감한데이터에뭐 어차피 스프링 들어가면 잘 안볼객체긴해서
        ServletContext context = getServletContext();

        Enumeration<String> enumeration = context.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement()); //이런게 존재한다
        }

        context.setAttribute("test","value"); // 키밸류추가
        //동일한 키로 context에 attr를 추가하면(수정)Replaced가 동작
        context.setAttribute("test","value2");
        context.removeAttribute("test");
        //context
    }
}
