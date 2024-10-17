<%--
  Created by IntelliJ IDEA.
  User: 803-17
  Date: 2024-10-17
  Time: 오후 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 조회할 사원의 정보를 보여줄 jsp-->
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    사원 번호 : ${requestScope.selectEmp.empId} <br/>
    <!--리퀘스트 겟 어트리부트를 스코프로  조금더 편하게 가져온다 알필요없다-->
    사원 명 : ${requestScope.selectEmp.empName} <br/>
    부서 코드 :${requestScope.selectEmp.deptCode} <br/>
    직급 코드 :${requestScope.selectEmp.jobCode} <br/>
    급여 : ${requestScope.selectEmp.salary}

</body>
</html>
