import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Garage from '../views/Garage.vue'
import Jungle from '../views/Jungle.vue'
import Ocean from '../views/Ocean.vue'
import Moon from '../views/Moon.vue'
import Jeep from '../views/Jeep.vue'
import Submarine from '../views/Submarine.vue'
import Rocket from '../views/Rocket.vue'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/farm',
    name: 'Farm',
    // route level code-splitting
    // this generates a separate chunk (farm.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "farm" */ '../views/Farm.vue')
  },
  {
    path: '/garage',
    name: 'Garage',
    component: Garage
  },
  {
    path: '/jungle',
    name: 'Jungle',
    component: Jungle
  },
  {
    path: '/ocean',
    name: 'Ocean',
    component: Ocean
  },
  {
    path: '/moon',
    name: 'Moon',
    component: Moon
  },
  {
    path: '/jeep',
    name: 'Jeep',
    component: Jeep
  },
  {
    path: '/submarine',
    name: 'Submarine',
    component: Submarine
  },
  {
    path: '/rocket',
    name: 'Rocket',
    component: Rocket
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
