package com.ohgiraffers.mvc.employee.model.service;

import com.ohgiraffers.mvc.employee.model.dao.EmployeeDAO;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.*;


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

    public int selectNewEmpId() {
        // AUTO_INCREMENT 가 걸려 있는 경우는 필요 없지만 , 제일 끝 번호를 추적해 직접 값을 넣어주는 메소드
        Connection con = getConnection();

        int newEmpId = empDAO.selectNewEmpId(con);

        close(con);

        return newEmpId;
    }

    public int insertEmp(EmployeeDTO emp) {
        Connection con = getConnection();

        int result = empDAO.insertEmp(con,emp);

        if (result > 0) {
            commit(con); //인서트가 정상적으로 커밋했을때 반영되게끔
        }else{
            rollback(con); //아님 롤백
        }
        close(con);
        return result;
    }

    public int UpdateEmployee(String empId , Date date) {
        Connection con = getConnection();

        int result = empDAO.UpdateEmp(con, empId,date);
        //커넥션 처음 받는곳
        if (result > 0) {
            commit(con); //인서트가 정상적으로 커밋했을때 반영되게끔
        }else{
            rollback(con); //아님 롤백
        }
        close(con);
        //조금이해안됨
        return result;

    }
}
