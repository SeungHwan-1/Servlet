
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
                  successMessage = "신규 직원 등록 성공"
                  break;
            case 'updateEmp' :
              successMessage = "직원 정보 수정 성공"
              break;
            case 'deleteEmp' :
              successMessage = "직원 정보 삭제 성공"
              break;
          }
          alert(successMessage); // 현재서버경로 가져올수있다 필터랑 비슷하다
          location.href = '${pageContext.servletContext.contextPath}/employee/list';
      })();
    </script>
</body>
</html>
