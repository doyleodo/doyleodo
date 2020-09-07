import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    singables: {
      id: "",
      singableName: "",
      description: "",
      isVehicle: "",
      sound: "",
      region: "",
    },
  },
  mutations: {
  },
  actions: {
  },
  modules: {
  }
})
