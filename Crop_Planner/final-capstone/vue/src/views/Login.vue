<template>
  <div id="login-login" class="text-center">
    <form class="form-signin-logon" >
      <h1 class="h3 mb-3 font-weight-normal">DIG IT!</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      
      <div class="field">
      <label for="username" class="sr-only">username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="username"
        v-model="user.username"
        required
        autofocus
      /></div>

      <div class="field">
      <label for="password" class="sr-only">password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="password"
        v-model="user.password"
        required
      /></div>
      
      <router-link :to="{ name: 'register' }" id="NeedAn">Need an account?</router-link>
      <a href="#" @click.prevent="login" class="button btn btn-lg btn-primary btn-block btn-login-login">Sign in</a>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/profile");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style>
#login-login {
  display: flex;
  flex-direction: column;
  justify-content: flex-start; 
  align-items: center;
  background-color: #85A183;
  margin: 0px 0 20px 0;
  width: 40%;
  border: 2px;
  border-style: solid;
  border-color: #85A183;
  border-radius: 25px;
}

.form-signin-logon {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 80%;

}

.field {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

label {
  margin-top: 15px;
  line-height: 2em;
}

input {
  width: 50ch;
  margin-top: 5px;
}

.btn-login-login {
  display: flex;
  color: white;
  text-align: center;
  align-items: center;
  border-radius: 15px;
  height: 2em;
  font-size: 1.2em;
  font-weight: 400;
  text-decoration: none;
  border-style: solid;
  padding: 10px 80px;
  background-color: #e48438;
  border-color: #e48438;
  box-shadow: 2px 2px 4px black;
  margin: 15px;
}

</style>