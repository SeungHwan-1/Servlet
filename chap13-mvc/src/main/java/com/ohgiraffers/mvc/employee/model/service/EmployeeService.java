package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;
import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.getConnection;


public class EmployeeService {

    private  final EmployeeDAO empDAO; //한번 생성하고 안바꾸려구 파이널

    public EmployeeService() { //생성자가 호출되면 필드에 empDao도 같이 생김
        empDAO = new EmployeeDAO();
    }


    public EmployeeDTO selectOneEmpById(String empId) {
        //자동완선 리턴값 인자값
        Connection con = getConnection();

        EmployeeDTO selectEmp = empDAO.selectEmpById(con, empId);
        //커넥션 처음 받는곳
        close(con);
        //조금이해안됨
        return selectEmp;
    }
    public List<EmployeeDTO> selectAllEmps() {
        Connection con = getConnection();

        List<EmployeeDTO> EmpList = empDAO.selectAll(con);
        close(con);
        return EmpList;
    }
}
