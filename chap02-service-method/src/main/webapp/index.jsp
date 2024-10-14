<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>service() method의 역할
</h1>
<br/>
<h3>GET 방식의 요청</h3>

<a href="request-service">서비스 메소드 요청하기</a>

<form action="request-service" method="get">
    <input type="submit" value="GET방식 요청 전송"/>
    </form>


    <h3>POST 방식의 요청</h3>
    <form action="request-service" method="post">
        <input type="submit" value="POST방식 요청 전송"/>
    </form>
</body>
</html>