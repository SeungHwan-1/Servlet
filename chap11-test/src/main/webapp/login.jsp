<%--
  Created by IntelliJ IDEA.
  User: 803-17
  Date: 2024-10-16
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<br/>
<form action="member/redirect" method="get">
    <label>아이디 :</label>
    <input type="text"placeholder="ID" name="userId">
    <br/>
    <label>비밀번호 :</label>
    <input type="password" placeholder="password" name="password1">
    <br/>
    <button type="submit">로그인</button>
</form>

<a href="index.jsp">회원가입하러가기</a>
</body>
</html>
