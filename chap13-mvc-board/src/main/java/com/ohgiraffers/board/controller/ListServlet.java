package com.ohgiraffers.board.controller;

import com.ohgiraffers.board.model.dto.BoardDTO;
import com.ohgiraffers.board.model.service.BoardService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BoardService empservice = new BoardService();
        List<BoardDTO> employeeList = empservice.selectAllbrd();


        String path="";
        if(employeeList != null)
        {
            path = "/WEB-INF/views/employee/employeeList.jsp";
            req.setAttribute("emp", employeeList);
            //
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "Employee not found");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
