package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //톰캣 서버 인코딩 설정 방식
        System.out.println(req.getCharacterEncoding());

        String name = req.getParameter("name");
        System.out.println("name : " +name);
        //인코딩을 제외한 값들은 GET 방식과 동일하게 꺼낼 수 있다.

        Map<String, String[]> requestMap = req.getParameterMap();
        Set<String> keys = requestMap.keySet();
        Iterator<String> iterator = keys.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            String[] values = requestMap.get(key);

            System.out.println("key : " + key);
            for(int i = 0; i < values.length; i++) {
                System.out.println("value{" + i + "} : " + values[i]);
            }

        }
    }
}
