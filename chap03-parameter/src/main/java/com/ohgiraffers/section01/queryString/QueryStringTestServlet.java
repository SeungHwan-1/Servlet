package com.ohgiraffers.section01.queryString;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/querystring")
public class QueryStringTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //service로 부터 전달 받은 HttpServletRequest는
        //요청시 전달한 값을 getParameter()로 추출할 수 있다
        // 이때 인자로 input 태그에 지정한 name  속성의 값을 문자열 형태로 전달하면 된다..
        String name = req.getParameter("name");
        System.out.println("이름 :" + name);

        int age = Integer.parseInt(req.getParameter("age"));
        System.out.println("나이 :" + age);

        java.sql.Date birthday = java.sql.Date.valueOf(req.getParameter("birthday"));
        System.out.println("생일 :" + birthday);

        //radio 태그는 여러 값 중 선택된 하나의 값만 전달된다..
        String gender = req.getParameter("gender");
        System.out.println("성별 :" + gender);

        //selectbox도 동일하다
        String national = req.getParameter("national");
        System.out.println("국적 :" + national);

        // checkbox 는 다중으로 입력을 받을 수 있어, 선택된 값이 문자열 배열로 전달된다.
        System.out.println("취미 :");
        String[] hobbies = req.getParameterValues("hobbies");

        for (String hobbie : hobbies) {
            System.out.print(hobbie);
        }

        /*
        * getParameterMap() - 모든 데이터를 Key,value 형태로 일괄 반환
         */
        Map<String,String[]> requestMap = req.getParameterMap();

        for (String key : requestMap.keySet()) {
            System.out.println(key + ":" + requestMap.get(key));
        }
    }
}
