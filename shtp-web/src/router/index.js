import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/view/Login'
import Regedit from '@/view/Regedit'
import Home from '@/view/Home'
import MainPage from '@/view/MainPage'
import Product from '@/view/Product'
import UpdateProduct from '@/view/UpdateProduct'
import Chat from '@/view/Chat'
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
          path: '/product',
          name: '产品',
          component: Product,
          hidden: true,
          meta: {
            keepAlive: false,
            requireAuth: true
          }
        },
        {
          path: '/updateProduct',
          name: '更新产品',
          component: UpdateProduct,
          hidden: true,
          meta: {
            keepAlive: true,
            requireAuth: true
          }
        },
        {
          path: '/chat',
          name: '消息',
          component: Chat,
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
