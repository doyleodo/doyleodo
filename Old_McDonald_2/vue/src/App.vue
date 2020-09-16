<template>
  <div id="app">
    <div id="nav">
      <router-link class="button_main_nav" to="/">Home</router-link>
      <router-link class="button_main_nav" to="/farm">Farm</router-link>
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  height: 100vh;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: lightgrey;
}

#nav {
  padding: 15px;
  background-color: lightgreen;
  display: flex;
  justify-content: flex-end;
}

.button_main_nav {
  background-color: lightsalmon;
  font-weight: bold;
  font-size: 20px;
  margin: 10px 30px;
  padding: 20px 30px;
  border-radius: 10px;
  text-decoration: none;
  box-shadow: 2px 2px 4px black;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
