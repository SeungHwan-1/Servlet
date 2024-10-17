
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--서블릿에서만 쓸 문법-->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>직원 전체 목록 조회</h1>
<table>
    <tr>
        <th>사원번호</th>
        <th>직원명</th>
        <th>주민번호</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>부서코드</th>
        <th>직급코드</th>
        <th>급여등급</th>
        <th>급여</th>
        <th>보너스율</th>
        <th>관리자사번</th>
        <th>입사일</th>
        <th>퇴사일</th>
        <th>퇴직여부</th>
    </tr>
    <c:forEach items="${requestScope.emp}" var="emp">
        <!--아이템스에 담긴 안에있는거 하나씩 꺼내서 c는위에있는거 emp에 담는다-->
        <tr>
            <th>${emp.empId}</th>
            <th>${emp.empName}</th>
            <th>${emp.empNo}</th>
            <th>${emp.email}</th>
            <th>${emp.phone}</th>
            <th>${emp.deptCode}</th>
            <th>${emp.jobCode}</th>
            <th>${emp.salLevel}</th>
            <th>${emp.salary}</th>
            <th>${emp.bonus}</th>
            <th>${emp.managerId}</th>
            <th>${emp.hireDate}</th>
            <th>${emp.enthate}</th>
            <th>${emp.entYn}</th>

        </tr>
    </c:forEach>
</table>
</body>
</html>
