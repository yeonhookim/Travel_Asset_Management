<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%-- JSTL 사용을 위한 선언 --%>

<html>
<head>
  <title>메인 페이지</title>
</head>
<body>

<%-- 로그인 상태인 경우: 닉네임과 로그아웃 표시 --%>
<c:choose>
  <c:when test="${not empty loginUser}">
    <h2>환영합니다, ${loginUser.nickname}님!</h2>
    <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
  </c:when>

  <%-- 비로그인 상태인 경우: 로그인/회원가입 링크 표시 --%>
  <c:otherwise>
    <h2>어서오세요, 게스트님!</h2>
    <a href="${pageContext.request.contextPath}/login">로그인</a>
    <a href="${pageContext.request.contextPath}/signup">회원가입</a>
  </c:otherwise>
</c:choose>

</body>
</html>