import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/api"
});

export default {


    getAllSupplies() {
        return http.get('/allSupplies');
    },


    
}