<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h2 class="h3 mb-3 font-weight-normal">Create Account</h2>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      
     <div class="fields"> 
      <div class="field">
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      </div>
      
      <div class="field">
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /></div>
      
      <div class="field">
      <label for="confirmpassword" class="sr-only">Confirm Password</label>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /></div>

      <div class="field">
      <label for="email" class="sr-only">Email</label>
      <input
        type="email"
        id="email"
        class="form-control"
        placeholder="user@site.com"
        v-model="user.email"
        required
      /></div>

      <div class="field">
     <label for="firstName" class="sr-only">First Name</label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstName"
        required
      /></div>

      <div class="field">
     <label for="lastName" class="sr-only">Last Name</label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastName"
        required
      /></div>

      <div class="field">
      <label for="city" class="sr-only">City</label>
      <input
        type="text"
        id="city"
        class="form-control"
        placeholder="city"
        v-model="user.city"
        required
      /></div>
      
      <div class="field">
      <label for="state" class="sr-only">State</label>
      <input
        type="text"
        id="state"
        class="form-control"
        placeholder="State"
        v-model="user.state"
        required
      /></div>

      <div class="field">
      <label for="zip" class="sr-only">Zip</label>
      <input 
        id="zip" 
        name="zip" 
        type="text" 
        inputmode="numeric" 
        class="form-control"
        placeholder="XXXXX"
        v-model="user.zip"
        required
      /></div>
     </div>

      <router-link :to="{ name: 'login' }" id="AlreadyHave">Already have an account?</router-link>
      <button  type="submit" class="button btn btn-lg btn-primary btn-block">
        Submit
      </button>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        email: '',
        firstName: '',
        lastName: '',
        city: '',
        state: '',
        zip: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
#register {
  display: flex;
  flex-direction: column;
  justify-content: flex-start; 
  align-items: center;
  background-color: #85A183;
  margin: 0px 0 20px 0;
  width: 60%;
  border: 2px;
  border-style: solid;
  border-color: #85A183;
  border-radius: 25px;
}

.form-register {
  display: flex;
  flex-direction: column;
  align-items: center;
    flex-grow: 1;
  width: 100%;

}

.field {
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  align-items: center;
  width: 100%;
}

label {
  display: flex;
  justify-items: flex-end;
  flex-grow: 1;
  margin-right: 15px;
  line-height: 2em;
  margin-bottom: 2px;
  width: 20ch;
  text-align: right;
}

input {
  width: 50ch;
  height: 2em;
}
</style>
