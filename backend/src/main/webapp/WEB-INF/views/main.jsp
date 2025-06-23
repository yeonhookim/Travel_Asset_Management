<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--내용: 로그인한 사용자의 닉네임이나 간단한 환영 메시지를 출력--%>
<html>
<head>
  <title>메인 페이지</title>
</head>
<body>
<h2>환영합니다, ${sessionScope.loginUser.nickname}님!</h2>
<a href="/logout">로그아웃</a>
</body>
</html>