import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Profile from '../views/Profile.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import AddGarden from '../views/AddGarden.vue'
import Garden from '../views/Garden.vue'
import Plot from '../views/Plot.vue'
import Zone from '../views/Zone.vue'
import store from '../store/index'
import EditProfile from '../views/EditProfile.vue'
import EditPlant from '../views/EditPlant.vue'
import AdminHome from '../views/AdminHome.vue'
import Shopping from '../views/Shopping.vue'
import AddPlant from '../components/AddPlant.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/profile',
      name: 'profile',
      component: Profile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/garden/:gardenid',
      name: 'garden',
      component: Garden,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/garden/:gardenid/plot/:plotid',
      name: 'plot',
      component: Plot,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/addgarden',
      name: 'add-garden',
      component: AddGarden,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/garden/:gardenid/shopping',
      name: 'shopping',
      component: Shopping,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/editprofile/:userid',
      name: 'edit-profile',
      component: EditProfile,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/zone/:zonename',
      name: 'zone',
      component: Zone,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/admin/home',
      name: 'adminhome',
      component: AdminHome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/admin/editplant/:plantid',
      name: 'edit-plant',
      component: EditPlant,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/admin/addplant',
      name: 'add-plant',
      component: AddPlant,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
