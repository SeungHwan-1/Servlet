package com.ohgiraffers.board.controller;

import com.ohgiraffers.board.model.dto.BoardDTO;
import com.ohgiraffers.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/board/insert")
public class InsertBoardServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        System.out.println("content = " + content);

        BoardService boardService = new BoardService();

        BoardDTO bDTO = new BoardDTO();
        bDTO.setTitle(title);
        bDTO.setContent(content);

        int result =  boardService.insertbrd(bDTO);
        if(result != 0) bDTO.setId(result);
        System.out.println("bDTO = " + bDTO);

        String path = "";
        if(result > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "insertEmp");

        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "신규 책 등록에 실패 하셨습니다");
        }
        //성공 실패여부에 따라서 다른페이지로 보내줌
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
