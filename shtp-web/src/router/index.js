import Vue from 'vue'
import Router from 'vue-router'
import Menubar from '@/component/Menubar'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: Menubar,
      name: Menubar
    }
  ]
})
