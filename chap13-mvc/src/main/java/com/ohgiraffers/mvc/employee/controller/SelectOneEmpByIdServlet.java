package com.ohgiraffers.mvc.employee.controller;

import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;
import com.ohgiraffers.mvc.employee.model.service.EmployeeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/employee/select")
public class SelectOneEmpByIdServlet extends HttpServlet {
    // 받으면 로직처리 후 특정 클래스한테 보내고 다시 jsp로 보내는?
    //컨트롤에서 서비스로 서비스는 DAO쪽에(데이터베이스직접적으로 맽은 객체(mapper)
    // 사원정보
    //컨트롤로 돌아오고 유효성까지 체크한이후에 돌려줄 예정


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empId = req.getParameter("empId");
        System.out.println("empId = " + empId);
        //form은 디폴트 겟
        //사번을 이용해 사원 정보를 조회하는 비지니스 로직을 호출
        EmployeeService empservice = new EmployeeService();
        EmployeeDTO selectEmp = empservice.selectOneEmpById(empId);
        //이렇게 쓰고나서 만드는게 편한게 자동완성이됌
        System.out.println("selectEmp = " + selectEmp);

        //실행 결과에 따라서 뷰연결
        //특정 사본에 요청을 보내고 어트리뷰트에 담아서 보내고
        // 없으면 실패 에러를 담아서 보냄
        String path="";
        if(selectEmp != null)
        {
            path = "/WEB-INF/views/employee/showEmpInfo.jsp";
            req.setAttribute("selectEmp", selectEmp);
            //쇼인포jsp
        }else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            req.setAttribute("message", "Employee not found");
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }
}
