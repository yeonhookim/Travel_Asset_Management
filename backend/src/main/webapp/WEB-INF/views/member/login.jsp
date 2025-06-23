<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--로그인 뷰 생성--%>
<html>
<head>
  <title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form action="/login" method="post">
  <label for="username">아이디:</label>
  <input type="text" name="username" id="username" required /><br/>

  <label for="password">비밀번호:</label>
  <input type="password" name="password" id="password" required /><br/>

  <input type="submit" value="로그인" />
</form>

<c:if test="${not empty loginError}">
  <p style="color:red;">${loginError}</p> <!-- 로그인 실패 시 메시지 -->
</c:if>
</body>
</html>