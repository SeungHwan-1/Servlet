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


    <!--리퀘스트 겟 어트리부트를 스코프로  조금더 편하게 가져온다 알필요없다-->
    타이틀 : ${requestScope.selectEmp.title} <br/>
    내용 :${requestScope.selectEmp.content} <br/>


</body>
</html>
