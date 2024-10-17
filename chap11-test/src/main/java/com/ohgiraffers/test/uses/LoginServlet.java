package com.ohgiraffers.test.uses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/member/redirect")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loginId = req.getParameter("userId");
        String loginpassword = req.getParameter("password1"); // 여기서 이미 암호화됨
        //
        StringBuilder responseText = new StringBuilder();


        HttpSession session = req.getSession();

        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());


            String userId = (String)session.getAttribute("userId"); //형변환이 필요할수있음
            String password = (String)session.getAttribute("password");

            System.out.println("userId = " + userId);
            System.out.println("password = " + password);
            resp.setContentType("text/html;charset=UTF-8");
            PrintWriter out = resp.getWriter(); // 머였지



            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            System.out.println("비밀번호가 확인" + passwordEncoder.matches(loginpassword,password));


            if(loginId.equals(userId) && passwordEncoder.matches(loginpassword,password))
            {
                out.println("<h3>로그인 완료</h3>");
                out.println("<a href=\"../index.jsp\">로그아웃 회원가입하러가기</a>");
            }
            else
            {

                responseText.append("<form action='/member/redirect' method='get'>\n") // 폼의 action과 메서드 설정
                        .append("제목: <input type='text' name='userId' required><br>\n") // 제목 입력 필드
                        .append("비밀번호: <input type='password' name='password1' required><br>\n") // 제목 입력 필드
                        .append("<input type='submit' value='로그인'>\n") // 제출 버튼
                        .append("</form>\n")
                        .append("</body>\n")
                        .append("</html>")
                        .append("<h2 style='color:red;'>")
                        .append("로그인안됌")
                        .append("</h2>\n")
                                .append("<a href=\"../index.jsp\">회원가입하러가기</a>");

                out.println(responseText);
            }

            out.flush();
            out.close();
        }
    }
}
