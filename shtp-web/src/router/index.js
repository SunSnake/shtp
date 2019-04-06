import Vue from 'vue'
import Router from 'vue-router'
import Menubar from '@/components/Menubar'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Menubar',
      component: Menubar
    }
  ]
})
