<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>마이페이지</title></head>
<body>
<h2>마이페이지</h2>

<form action="/mypage" method="post">
    <!-- 아이디는 수정 불가, 출력만 -->
    <p>ID: ${member.username}</p>

    <!-- 이름 수정 입력란 -->
    <p>이름: <input type="text" name="name" value="${member.name}"/></p>

    <!-- 이메일 수정 입력란 -->
    <p>이메일: <input type="text" name="email" value="${member.email}"/></p>

    <!-- 히든 필드: 수정할 대상 식별용 -->
    <input type="hidden" name="username" value="${member.username}"/>

    <!-- 제출 버튼 -->
    <button type="submit">수정</button>
</form>

<!-- 메인 페이지로 이동 링크 -->
<a href="/main">메인으로</a>
</body>
</html>