package com.ohgiraffers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/writepost")
public class WritePostServlet extends HttpServlet {

    // GET 요청 처리: 게시글 작성 폼 반환
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HTML 폼을 작성하여 사용자에게 반환
        StringBuilder responseText = new StringBuilder();

        // 응답의 콘텐츠 타입 설정
        response.setContentType("text/html;charset=UTF-8");

        // HTML 폼을 작성하여 사용자에게 반환
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<title>게시글 작성</title>\n") // 페이지 제목
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>게시글 작성</h1>\n");

        // 오류 메시지가 있는 경우 출력
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
            responseText.append("<h2 style='color:red;'>").append(errorMessage).append("</h2>\n");
        }

        // 폼 생성
        responseText.append("<form action='writepost' method='post'>\n") // 폼의 action과 메서드 설정
                .append("제목: <input type='text' name='title' required><br>\n") // 제목 입력 필드
                .append("내용: <textarea name='details' required></textarea><br>\n") // 내용 입력 필드
                .append("<input type='submit' value='작성하기'>\n") // 제출 버튼
                .append("</form>\n")
                .append("</body>\n")
                .append("</html>");

        // 최종적으로 작성한 HTML을 응답으로 전송
        PrintWriter out = response.getWriter();
        out.println(responseText.toString());
        out.flush();  // 여기서 전체 다 뿌려줌
        out.close();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청에서 제목과 내용 파라미터 가져오기
        String title = request.getParameter("title");
        String details = request.getParameter("details");

        // 제목과 내용 검증
        if (title.length() < 5) {
            // 제목이 5자 미만일 경우 오류 메시지를 request에 저장
            request.setAttribute("errorMessage", "제목은 5자 이상이어야 합니다.");
            doGet(request, response); // 입력 폼 다시 보여주기
            return;  // doPost 메소드 종료
        }

        if (details.length() < 10) {
            // 제목이 5자 미만일 경우 오류 메시지를 request에 저장
            request.setAttribute("errorMessage", "내용은 10자 이상이어야 합니다.");
            doGet(request, response); // 입력 폼 다시 보여주기
            return;  // doPost 메소드 종료
        }

        // 게시글 제목과 내용을 request에 저장
        request.setAttribute("title", title);
        request.setAttribute("details", details);

        // ResultServlet으로 포워드
        RequestDispatcher rd = request.getRequestDispatcher("result");
        rd.forward(request, response);
    }
}