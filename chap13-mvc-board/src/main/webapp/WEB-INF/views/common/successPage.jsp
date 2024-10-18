
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
      //즉시실행 함수
      (function (){
          const successCode = `${requestScope.successCode}`;
          let successMessage = "";

          switch (successCode) {
            case 'insertEmp' :
                  successMessage = "신규 책 등록 성공"
                  break;
            case 'updateEmp' :
              successMessage = "책 정보 수정 성공"
              break;
            case 'deleteEmp' :
              successMessage = "책 정보 삭제 성공"
              break;
          }
          alert(successMessage); // 현재서버경로 가져올수있다 필터랑 비슷하다
          location.href = '${pageContext.servletContext.contextPath}/board/list';
          //성공했을때 거기 jsp로
      })();
    </script>
</body>
</html>
