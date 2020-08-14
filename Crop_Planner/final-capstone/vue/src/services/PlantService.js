import axios from 'axios';

const http = axios.create( {
    baseURL: "http://localhost:8080/api"
});

export default {
    getAllPlants() {
        return http.get("/allPlants");
    },

    updatePlantInfo(plant) {
        return http.put(`/editplant/${plant.id}`, plant);
      },
      
      addPlant(plant) {
        return http.post(`/addplant`, plant);
      },
    
      deletePlant(id) {
        return http.delete(`/plant/${id}`);
      }

    
};