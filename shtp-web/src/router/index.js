import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/Login'
import Regedit from '@/view/Regedit'
import Home from '@/view/Home'
import MainPage from '@/view/MainPage'
import Order from '@/view/Order'
import FriendChat from '@/view/FriendChat'
import Askbuy from '@/view/Askbuy'

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
      path: '/regedit',
      name: 'Regedit',
      component: Regedit,
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
          component: MainPage,
          hidden: false,
          meta: {
            keepAlive: true,
            requireAuth: true
          }
        },
        {
          path: '/order',
          name: '订单',
          component: Order,
          hidden: true,
          meta: {
            keepAlive: false,
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
        },
        {
          path: '/askBuy',
          name: '求购',
          component: Askbuy,
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
