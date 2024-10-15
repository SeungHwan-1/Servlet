package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet("/formdata")
public class signup extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getCharacterEncoding());
        String name = req.getParameter("name");
        System.out.println("이름 :" + name);

        String phonenumber = req.getParameter("phone");
        System.out.println("전화번호 :" + phonenumber);

        String password = req.getParameter("password");
        System.out.println("비밀번호 :" + password);

        String Checkpassword = req.getParameter("checkpassword");
        System.out.println("비밀번호 확인 :" + Checkpassword);

        String nameRegex = "^[가-힣]+$";
        String phoneRegex = "^\\d+$";

        boolean isNameValid = name.matches(nameRegex);
        boolean isPhoneValid = phonenumber.matches(phoneRegex);

        if(!Checkpassword.equals(password) || password.length() < 8)
        {

            resp.sendError(500,"비밀번호를 다시확인해주세요");
        }
           else if(name.length()<2)
        {
            resp.sendError(500,"이름 두글자이상");
        }
         else if(!(phonenumber.length() == 11) || !isPhoneValid)
        {
            resp.sendError(500,"폰번호 다시확인좀");
        }
         else if (!isNameValid) {
            resp.sendError(500,"아이디 한글만 가능");
        }
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>"+name+ "님환영합니다</h1>\n")
                .append("</body>\n")
                .append("</html>");

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println(responseBuilder);
        out.close();
    }

}
