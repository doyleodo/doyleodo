import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    singables: {
      id: "",
      name: "",
      description: "",
      isVehicle: "",
      sound: "",
      region: "",
    },
  },
  mutations: {
    SET_SINGABLES(state, data) {
      state.singables = data;
    }
  },
  actions: {
  },
  modules: {
  }
})
