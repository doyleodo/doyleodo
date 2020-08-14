import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api"
});

export default {


    getPlotsByGardenId(gardenID) {
        return http.get(`/garden/${gardenID}/plots`)
    },

    saveGardenPlots(plots, gardenID) {
      return http.post(`/garden/${gardenID}/plots`, plots)
  }
    
}