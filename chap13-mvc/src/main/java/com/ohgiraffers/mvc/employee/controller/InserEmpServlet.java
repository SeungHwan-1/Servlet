package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet("/employee/insert")
public class InserEmpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empName = req.getParameter("empName");
        String empNo = req.getParameter("empNo");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String deptCode = req.getParameter("deptCode");
        String jobCode = req.getParameter("jobCode");
        String salLevel = req.getParameter("salLevel");
        int salary = parseInt(req.getParameter("salary"));
        double bonus = Double.parseDouble(req.getParameter("bonus"));
        String managerId = req.getParameter("managerId");
        java.sql.Date hireDate = java.sql.Date.valueOf(req.getParameter("hireDate"));

        // 쿼리문을 열려서 제일 마지막 아이디에 1을 넣어서  오토 인크리먼트
        EmployeeService employeeService = new EmployeeService();

        int newEmpId = employeeService.selectNewEmpId();//여기에 넣으면 그게 최신
        System.out.println("newEmpId = " + newEmpId);

        EmployeeDTO emp = new EmployeeDTO();
          if(newEmpId != 0) emp.setEmpId(String.valueOf(newEmpId));

          emp.setEmpName(empName);
          emp.setEmpNo(empNo);
          emp.setEmail(email);
          emp.setPhone(phone);
          emp.setDeptCode(deptCode);
          emp.setJobCode(jobCode);
          emp.setSalLevel(salLevel);
          emp.setSalary(salary);
          emp.setBonus(bonus);
          emp.setManagerId(managerId);
          emp.setHireDate(hireDate);

        System.out.println("emp = " + emp);

        int result =  employeeService.insertEmp(emp);

         String path = "";
         if(result > 0){
             path = "/WEB-INF/views/common/successPage.jsp";
             req.setAttribute("successCode", "insertEmp");

         }else {
             path = "/WEB-INF/views/common/errorPage.jsp";
             req.setAttribute("message", "신규 직원 등록에 실패 하셨습니다");
         }
            //성공 실패여부에 따라서 다른페이지로 보내줌
         req.getRequestDispatcher(path).forward(req, resp);
    }
}
