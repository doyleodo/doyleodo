<template>
  <div class="farm">
    <h2>You wander the farm looking at all the animals.  They seem happy.  A song runs through your head</h2>
    <p>Old McDonald had a farm E-I-E-I-O</p>
    <p>And on this farm he had a [ANIMAL] E-I-E-I-O</p>
    <p>with a [NOISE NOISE] here, and a [NOISE NOISE] there,</p>
    <p>here a [NOISE], there a [NOISE],</p>
    <p>Everywhere a [NOISE NOISE]</p>
    <p>Old McDonald had a farm E-I-E-I-O</p>
  <div class="links">
    <router-link class="btn" to="/farm">Check on a different animal</router-link>
    <router-link class="btn" to="/garage">I'm bored and want to check out my garage</router-link>
    <router-link class="btn" to="/">Go back home</router-link>
  </div>
  </div>
</template>

<style>
p {
  font-size: 20px;
  font-style: italic;
}

.links {
  display: flex;
  justify-content: center;
}

.btn {
  background-color: lightsalmon;
  color: beige;
  font-weight: bold;
  font-size: 20px;
  margin: 50px 20px;
  padding: 20px 10px;
  border-radius: 10px;
  text-decoration: none;
  box-shadow: 2px 2px 4px black;
  /* width: 300px; */
}

</style>