import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/Login'
import Home from '@/view/Home'
import FriendChat from '@/view/FriendChat'
import mainPage from '@/view/MainPage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login,
      hidden: true
    },
    {
      path: '/home',
      name: '主页',
      component: Home,
      hidden: true,
      meta: {
        requireAuth: true
      },
      children: [
        {
          path: '/mainPage',
          name: '主页列表',
          component: mainPage,
          hidden: false,
          meta: {
            keepAlive: true,
            requireAuth: true
          }
        },
        {
          path: '/chat',
          name: '消息',
          component: FriendChat,
          hidden: true,
          meta: {
            keepAlive: false,
            requireAuth: true
          }
        }
      ]
    }
  ]
})
