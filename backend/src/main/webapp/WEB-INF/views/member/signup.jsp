<%--회원가입 폼 화면 (프론트에서 입력 받음)--%>
<form action="/member/signup" method="post">
  <input type="text" name="username" placeholder="아이디" required />
  <input type="password" name="password" placeholder="비밀번호" required />
  <input type="text" name="nickname" placeholder="닉네임" />
  <button type="submit">가입하기</button>
</form>