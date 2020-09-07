<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>
      This aint your Grandma's Old McDonald!
    </h2>
    <h3>Your breakfast is finished.  It's time to saunter out and look at your farm animals.</h3>
    <h3>SIGH...those same ol' farm animals again?</h3>
    <h3>Well, let's get to it.</h3>

    <router-link class="btn-to-farm" to="/farm">Check the farm</router-link>
    <router-link class="btn-to-farm" to="/farm">Take a Guided Tour</router-link>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}

.hello {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.btn-to-farm {
  background-color: lightsalmon;
  color: beige;
  font-weight: bold;
  font-size: 20px;
  margin: 20px 30px;
  padding: 20px 30px;
  border-radius: 10px;
  text-decoration: none;
  box-shadow: 2px 2px 4px black;
  width: 300px;
}

</style>