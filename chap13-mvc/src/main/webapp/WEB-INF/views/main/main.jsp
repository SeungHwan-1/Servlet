<%--
  Created by IntelliJ IDEA.
  User: 803-17
  Date: 2024-10-17
  Time: 오후 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/> <!--여기에 해더 jsp를 포함하라는것 -->

<h3>Employee 테이블에서 EMP_ID 를 이용하여 사원 정보 조회해오기</h3>
    <form action="employee/select">
        <label>조회할 사번 :</label>
        <input type="text" name="empId"/>
        <button type="submit">조회하기</button>
    </form>
    <h3>Employee 테이블에서 직원 전체 정보 조회 (퇴사하지 않은 직원만.) : employee/list</h3>
    <a href="employee/list">직원 정보 전체 조회하기 </a>

    <h3>EMPLOYEE 테이블에서 신규 직원 정보 추가 (필요한 정보를 입력받을 수 있는 form을 만들어서 추가할 것) : /employee/insert (post)</h3>
    <form action="employee/insert" method="post">
        직원명 : <input type="text" name="empName"><br>
        주민등록번호 : <input type="text" name="empNo"><br>
        이메일 : <input type="email" name="email"><br>
        전화번호 : <input type="tel" name="phone"><br>
        부서코드 :
        <select name="deptCode">
            <option value="D1">인사관리부</option>
            <option value="D2">회계관리부</option>
            <option value="D3">마케팅부</option>
            <option value="D4">국내영업부</option>
            <option value="D5">해외영업1부</option>
            <option value="D6">해외영업2부</option>
            <option value="D7">해외영업3부</option>
            <option value="D8">기술지원부</option>
            <option value="D9">총무부</option>
        </select>
        <br>
        직급코드 :
        <select name="jobCode">
            <option value="J1">대표</option>
            <option value="J2">부사장</option>
            <option value="J3">부장</option>
            <option value="J4">차장</option>
            <option value="J5">과장</option>
            <option value="J6">대리</option>
            <option value="J7">사원</option>
        </select>
        <br>
        급여등급 :
        <select name="salLevel">
            <option value="S1">S1</option>
            <option value="S2">S2</option>
            <option value="S3">S3</option>
            <option value="S4">S4</option>
            <option value="S5">S5</option>
            <option value="S6">S6</option>
        </select>
        <br>
        급여 : <input type="number" name="salary"><br>
        보너스율 : <input type="text" name="bonus"><br>
        관리자사번 : <input type="text" name="managerId"><br>
        입사일 : <input type="date" name="hireDate"><br>
        <button type="submit">등록하기</button>
    </form>

    <h3>Employee 테이블에서 직원 해고 처리 /employee/update</h3>
        <form action="employee/update" method="post">
            사번 : <input type="text" name="empId"><br/>
            퇴사일 : <input type="date" name="entDate">
            <button type="submit">직원 퇴사</button>
        </form>
</body>
</html>
