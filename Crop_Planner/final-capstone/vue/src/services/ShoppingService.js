import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api"
});

export default {


    generateSeedlingShoppingList(gardenId) {
        return http.get(`/generateSuggestedSeedlingList/${gardenId}/`);
    },

    saveGardenPlots(plots, gardenId) {
      return http.post(`/garden/${gardenId}/plots`, plots)
  },
  
  addItemToList(shoppingList, gardenId) {
    return http.post(`/addToMyShoppingList/${gardenId}`, shoppingList)
},

getShoppingLists(gardenId) {
    return http.get(`/myShoppingList/${gardenId}`)
}
 
    
}