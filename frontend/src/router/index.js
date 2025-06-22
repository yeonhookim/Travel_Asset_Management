import { createRouter, createWebHistory } from 'vue-router'

import HomePage from '../pages/HomePage.vue'
import LoginPage from '../pages/LoginPage.vue'
import MyTripsPage from '../pages/MyTripsPage.vue'
import WeatherPage from '../pages/WeatherPage.vue'
import ProfilePage from '../pages/ProfilePage.vue'

const routes = [
  { path: '/', component: HomePage },
  { path: '/login', component: LoginPage },
  { path: '/trips', component: MyTripsPage },
  { path: '/weather', component: WeatherPage },
  { path: '/profile', component: ProfilePage }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router
