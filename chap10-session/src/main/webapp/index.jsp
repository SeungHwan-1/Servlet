<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session</title>
</head>
<body>
<h1>session handling
</h1>
<br/>
            <form action="session" method="post">
                <table>
                    <tr>
                        <td>first name :</td>
                        <td><input type="text" name="firstName"/> </td>
                    </tr>
                    <tr>
                        <td>last name :</td>
                        <td><input type="text" name="lastName"/> </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit">전송</button>
                        </td>
                    </tr>
                </table>
            </form>
</body>
</html>