import Vue from 'vue'
import Router from 'vue-router'
import Menubar from '@/components/Menubar'
import Login from  '@/views/Login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Menubar',
      component: Menubar
    },
    {
      path: '/login ',
      name: 'Login',
      component: Login
    }
  ]
})
