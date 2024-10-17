        <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>
        <head>
            <title>Filter</title>
        </head>
        <body>
        <h1>filter의 라이프 사이클
        </h1>
        <br/>
        <a href="first/filter">filter 사용하기</a>
        <hr/>

        <h1>필터의 활용</h1>

        <form action="member/regist" method="post">
                <label>아이디 :</label>
                <input type="text" name="userId">
                <br/>
                <label>비밀번호 :</label>
                <input type="password" name="password">
                <br/>
                <label>이름 :</label>
                <input type="text" name="name">
                <br/>
                <button type="submit">가입하기</button>
        </form>
        </body>
        </html>