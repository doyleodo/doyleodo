<template>
  <div id="app">
    <div id="app-home" v-if="isHome">
      <div id="header">
        <a href="/">
          <img
            v-bind:class="isHome ? '' : 'shrink-nav' "
            class="logo"
            src="./img/digit.png"
            alt="digit logo"
          />
        </a>
        <div id="nav">
          <router-link class=" btn-main-nav" v-bind:to="{ name: 'home' }" v-if="!isHome">Home</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token === ''"
            v-show="!isLogin"
          >Login</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'profile' }"
            v-if="$store.state.token != '' && $route.name != 'profile'"
          >Profile</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
          >Logout</router-link>
        </div>
      </div>

      <div id="main-view">
        <router-view />
      </div>
    </div>

    <div id="not-home" v-else>
      <div id="header">
        <a href="/">
          <img
            v-bind:class="isHome ? '' : 'shrink-nav' "
            class="logo"
            src="./img/digit.png"
            alt="digit logo"
          />
        </a>
        <div id="nav">
          <router-link class=" btn-main-nav" v-bind:to="{ name: 'home' }" v-if="!isHome">Home</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'login' }"
            v-if="$store.state.token === ''"
            v-show="!isLogin"
          >Login</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'profile' }"
            v-if="$store.state.token != '' && $route.name != 'profile'"
          >Profile</router-link>
          <router-link
            class=" btn-main-nav"
            v-bind:to="{ name: 'logout' }"
            v-if="$store.state.token != ''"
          >Logout</router-link>
        </div>
      </div>

      <div id="main-view">
        <router-view />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    isHome() {
      return this.$route.name === "home";
    },
    isLogin() {
      return this.$route.name === "login";
    },
  },
};
</script>

<style>

#app-home {
  background-image: url("img/HomePic.jpg");
  background-repeat: no-repeat;
  background-size: 200vh;
  background-position: center;

}

#app {
  background-color: #c1c56d;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  font-family: "Raleway", sans-serif;
 }

#header {
  background-color: #c1c56d;
  display: flex;
  flex-grow: 1;
  align-items: center;
}

.logo {
  margin: 20px 0px 20px 60px;
  width: 200px;
}

.shrink-nav {
  width: 150px;
}

#nav {
  padding-right: 60px;
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  align-items: center;
}

.btn-main-nav {
  padding: 20px;
  height: 28px;
  border-radius: 28px;
  width: 16ch;
  margin-left: 20px;
  color: white;
  font-size: 1.4em;
  font-weight: 200;
  text-align: center;
  text-decoration: none;
  align-items: center;
  background-color: #e48438;
  box-shadow: 2px 2px 4px black;
}

.btn-lg {
  margin: 20px 15px;
  width: 250px;
  font-size: 1.4em;
  display: flex;
  justify-content: center;
  align-content: center;
  text-align: center;
  border: none;
}

#NeedAn,
#AlreadyHave {
  margin: 20px 0px;
}

h1,
h2,
h3,
h4 {
  font-family: "Kameron", serif;
}

#main-view {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  align-content: center;
  min-height: 80vh;
  width: 100%;
  
}
</style>