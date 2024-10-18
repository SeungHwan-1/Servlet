
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--서블릿에서만 쓸 문법-->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>책 전체 목록 조회</h1>
<table>
    <tr>
        <th>제목</th>
        <th>내용</th>
        <th>아이디</th>

    </tr>
    <c:forEach items="${requestScope.emp}" var="emp">
        <!--아이템스에 담긴 안에있는거 하나씩 꺼내서 c는위에있는거 emp에 담는다-->
        <tr>

            <th>${emp.title}</th>
            <th>${emp.content}</th>


        </tr>
    </c:forEach>
</table>
</body>
</html>
