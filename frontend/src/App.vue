<template>
  <div>
    <nav>
      <router-link to="/">홈</router-link> |
      <router-link to="/login">로그인</router-link> |
      <router-link to="/trips">내 여행</router-link> |
      <router-link to="/weather">날씨</router-link> |
      <router-link to="/profile">회원정보</router-link>
    </nav>
    <hr />
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>