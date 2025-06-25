<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Error</title>
</head>
<body>
<h1>❌ 오류 발생</h1>
<a href="${pageContext.request.contextPath}/">메인으로 가기</a>
<p>${exception}</p>
</body>
</html>