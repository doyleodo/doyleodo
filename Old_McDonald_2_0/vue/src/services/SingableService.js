import axios from 'axios';

const http = axios.create( {
    baseULR: "http://localhost: 8080/api"
});

export default {
    getAllSingables() {
        return http.get("/allSingables");
    }

};