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
  <div class="list">
    <h2>List all animals in Database</h2>
      <div class="singable" v-for="singable in $store.state.singables" v-bind:key="singable.singableName">
        <!-- <p v-bind:for="`Singable-${singable.id}`">{{singable.singableName}}</p> -->
                <p>{{ singable.id }}  {{ singable.name }}  {{ singable.description }} {{ singable.isVehicle }} {{ singable.sound }} {{ singable.region }}</p>

      </div>
  </div>
  </div>
</template>

<script>
import SingableService from "../services/SingableService";

export default {
  created() {
    SingableService.getAllSingables()
      .then((response) => {
        this.$store.commit("SET_SINGABLES", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Singable data not available.");
          // this.$router.push("/");
        }
      });
  },
  name:"farm",
  // data() {
  //   return {
  //     singable: {
  //       id: "",
  //       singableName: "",
  //       description: "",
  //       isVehicle: "",
  //       sound: "",
  //       region: "",
  //     },
  //   };
  // },
};
</script>

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

.singable {
  background-color: rgb(177, 177, 231);
}

</style>