package com.ohgiraffers.mvc.employee.model.dao;

import com.ohgiraffers.mvc.common.config.ConfigLocation;
import com.ohgiraffers.mvc.employee.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.mvc.common.jdbc.JDBCTemplate.close;

public class EmployeeDAO {

    private final Properties prop;

    public EmployeeDAO() {
        prop = new Properties(); // 생성될때 파일로드

        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION +
                    "/employee-mapper.xml")); //아까 경로 까지만 넣어서 파일명도 같이 넣어줌
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeDTO selectEmpById(Connection con, String empId) {
        PreparedStatement pstmt = null;

        ResultSet rset = null;

        EmployeeDTO selectEmp = null;

        String query = prop.getProperty("selectEmpById");

        try {
            pstmt = con.prepareStatement(query); //컨
            pstmt.setString(1, empId); // 쿼리문 물음표에 담는거 기억도안나네.
            rset = pstmt.executeQuery(); //결과를 담음

            if(rset.next()) {
                selectEmp = new EmployeeDTO();

                selectEmp.setEmpId(rset.getString("EMP_ID"));
                selectEmp.setEmpName(rset.getString("EMP_NAME"));
                selectEmp.setDeptCode(rset.getString("DEPT_CODE"));
                selectEmp.setJobCode(rset.getString("JOB_CODE"));
                selectEmp.setSalary(rset.getInt("SALARY"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmp;
    }
    public List<EmployeeDTO> selectAll(Connection con) {
        PreparedStatement pstmt = null;

        ResultSet rset = null;

        List<EmployeeDTO> selectEmpList = new ArrayList<>();

        String query = prop.getProperty("selectAll");

        try {
            pstmt = con.prepareStatement(query); //컨
           // 쿼리문 물음표에 담는거 기억도안나네.
            rset = pstmt.executeQuery(); //결과를 담음

            while(rset.next()) { //와일문으로 알넥스트하면서 객체생성하고 리스트에 애드
                EmployeeDTO employee = new EmployeeDTO();

                employee.setEmpId(rset.getString("EMP_ID"));
                employee.setEmpName(rset.getString("EMP_NAME"));
                employee.setEmpNo(rset.getString("EMP_NO"));
                employee.setEmail(rset.getString("EMAIL"));
                employee.setPhone(rset.getString("PHONE"));
                employee.setDeptCode(rset.getString("DEPT_CODE"));
                employee.setJobCode(rset.getString("JOB_CODE"));
                employee.setSalLevel(rset.getString("SAL_LEVEL"));
                employee.setSalary(rset.getInt("SALARY"));
                employee.setBonus(rset.getInt("BONUS"));
                employee.setManagerId(rset.getString("MANAGER_ID"));
                employee.setHireDate(rset.getDate("HIRE_DATE"));
                employee.setEntDate(rset.getDate("ENT_DATE"));
                employee.setEntYn(rset.getString("ENT_YN"));



                selectEmpList.add(employee); // 리스트에 추가
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(rset);
            close(pstmt);
        }
        return selectEmpList;
    }

}
