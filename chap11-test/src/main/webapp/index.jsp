<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입 페이지</title>
</head>
<body>
<h1>회원가입</h1>
<br/>
<form action="member/regist" method="post">
    <label>아이디 :</label>
    <input type="text"placeholder="ID" name="userId">
    <br/>
    <label>비밀번호 :</label>
    <input type="password" placeholder="password" name="password">
    <br/>
    <label>이메일 :</label>
    <input type="text"placeholder="E-mail" name="email">
    <br/>
    <button type="submit">가입하기</button>
</form>
<a href="login.jsp">로그인하러가기</a>
</body>
</html>