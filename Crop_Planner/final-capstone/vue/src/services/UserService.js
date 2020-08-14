import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:8080/api"
});

export default {

  getUserInfo(id) {
    return http.get(`/user/${id}`);
  },

  updateUserInfo(user) {
    return http.put('/editProfile', user);
  },
  
  addUser(id) {
    return http.post(`/user/${id}`);
  },

  deleteUser(id) {
    return http.delete(`/user/${id}`);
  }



}