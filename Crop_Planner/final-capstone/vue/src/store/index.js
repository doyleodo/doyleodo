import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));
const currentUserData = JSON.parse(localStorage.getItem('userData'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    seedlingShoppingLists: [],
    shoppingLists: [],
    token: currentToken || '',
    user: currentUser || {},
    userData: currentUserData || {},
    vegetable: "",
    gardens: [],
    plots: [],
    supplies: [],
    garden: {
      userId: "",
      gardenId: "",
      gardenName: "",
      gardenWidth: "",
      gardenLength: "",
    },
    plants: {
      plantId: "",
      plantName: "",
      description: "",
      plantsPerSqFoot: "",
      sunRequirements: "", 
      region: "", 
      seedlingCost: ""
    },
    zone: {
      zoneName: "",
      avgLastFrostMonth: "",
      avgLastFrostDay: "",
      avgFirstFrostMonth: "",
      avgFirstFrostDay: "",
      avgGrowingDays: ""
    },

    zonePlants: {
      id: "",
      name: "",
      description: "",
      plantsPerSqFoot: "",
      sunRequirements: "", 
      region: "", 
      seedlingCost: ""
    },

    supply: {
      supplyId: "",
      supplyName: "",
      supplyCost: ""
     },

  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    SET_USER_DATA(state, userData) {
      state.userData = userData;
      localStorage.setItem('userData',JSON.stringify(userData));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_PLANTS(state, data) {
      state.plants = data;
    },
    SET_ZONE(state, data) {
      state.zone = data;
    },
    SET_ZONE_PLANTS(state, data) {
      state.zonePlants = data;
    },
    ADD_PLOT(state,plot) {
      const garden = this.state.gardens.find(p => p.id == plot.id);
      garden.plot.unshift(plot);
    },
    SET_GARDEN(state, data) {
      state.garden = data;
    },    
    ADD_GARDEN(state, data) {
      state.gardens.push(data);
      state.garden = data;
    },
    SET_GARDENS(state, data) {
      state.gardens = data;
    },
    SET_PLOTS(state, data) {
      state.plots = data;
    },
    SET_VEGETABLE(state, data) {
      state.vegetable = data;
    },  
    SET_SHOPPING_LISTS(state, data) {
      state.shoppingLists.push(data);
    },
    SET_SEEDLING_SHOPPING_LISTS(state, data) {
      state.seedlingShoppingLists.push(data);
    },
    SET_SUPPLY(state, data) {
      state.supply = data;
    },
    SET_SUPPLIES(state, data) {
      state.supplies = data;
    }   
    
  }
})
