<template>
  <div class="home-container-home">

  <div class="home-title-bar logged" v-if="$store.state.token != ''">
    <h1>Hey {{$store.state.userData.firstName}}, let's get digging!</h1>
    <h2>Your profile is always a great place to start.</h2>

  </div>
  <div class="home-title-bar" v-else>
    <h1>Let's get digging!</h1>
    <h2>Dig It! is an online gardening app that helps you create a vegetable garden.</h2>
  </div>
    <user-steps class="user-steps"/>
  
  <div class="home-links-container">
    <router-link  class="btn-garden btn-create-account" v-bind:to="{ name: 'register' }" v-if="$store.state.token === ''">
      Create an Account
    </router-link>
  </div>
  
</div>
  
</template>

<script>
import UserSteps from '@/components/UserSteps'

export default {
  name: "home",
  components: {
    UserSteps
  }
};
</script>

<style>

.home-container-home {
  display: flex;
  width: 85%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: 20px 0px;
  background-color: rgba(193, 197, 109, 0.8);
  border-radius: 20px;

}
.home-title-bar {
  display: flex;
  width: 60%;
  padding-top: 15px;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.home-title-bar h1, .home-title-bar h2 {
  display: flex;
  text-justify: center;
  margin: 0 0 10px 0;

}


.home-links-container {
  display: flex;
  flex-direction: row;
  justify-content: center;
  margin-bottom: 20px;
}

.user-steps {
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
}

.btn-create-account {
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
  padding: 10px 40px;
  background-color: #307c55;
  border-color: #307c55;
  box-shadow: 2px 2px 4px black;
  margin: 15px;
}



</style>