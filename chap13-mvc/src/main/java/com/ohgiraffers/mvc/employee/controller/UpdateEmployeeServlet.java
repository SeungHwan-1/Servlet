package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/employee/update")
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String empId = req.getParameter("empId");
        Date hireDate = Date.valueOf(req.getParameter("entDate"));

        System.out.println("empId = " + empId);
        System.out.println("hireDate = " + hireDate);
        EmployeeService empservice = new EmployeeService();
        int emp = empservice.UpdateEmployee(empId,hireDate);



        String path = "";
        if(emp > 0){
            path = "/WEB-INF/views/common/successPage.jsp";
            req.setAttribute("successCode", "updateEmp");

        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "신규 직원 등록에 실패 하셨습니다");
        }
        //성공 실패여부에 따라서 다른페이지로 보내줌
        req.getRequestDispatcher(path).forward(req, resp);

    }
}
