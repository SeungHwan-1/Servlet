package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employee/list")
public class EmployeeListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        EmployeeService empservice = new EmployeeService();
        List<EmployeeDTO> employeeList = empservice.selectAllEmps();


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
