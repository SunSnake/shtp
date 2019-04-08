import Vue from 'vue'
import Router from 'vue-router'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      redirect: '/login' //重定向到登录页面
    },
    {
      path: '/login',
      component: _import('Login'),
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/regedit',
      component: _import('Regedit'),
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/home',
      component: _import('Home'),
      meta: {
        keepAlive: true
      }
    }
  ]
})
