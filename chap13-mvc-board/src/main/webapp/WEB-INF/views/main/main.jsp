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

<h3>추가한 게시판 조회</h3>
    <form action="board/select">
        <label>조회할 책번호 :</label>
        <input type="text" name="Id"/>
        <button type="submit">조회하기</button>
    </form>

    <h3>책 전체 정보 조회 (퇴사하지 않은 책만.) : board/list</h3>
    <a href="board/list">책 전체 조회하기 </a>

    <h3>게시판 추가</h3>
    <form action="board/insert" method="post">
        제목 : <input type="text" name="title"><br>
        내용 : <input type="text" name="content"><br>
        <button type="submit">등록하기</button>
    </form>

    <h3>게시판 해고 처리 /board/update</h3>
        <form action="board/update" method="post">

            <button type="submit">게시판 퇴사</button>
        </form>
</body>
</html>
