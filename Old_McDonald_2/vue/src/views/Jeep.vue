<template>
  <div>
    <img src="../assets/jeep.jpg" alt="">
    <VehicleSong class="vehicle-song"> v-if="this.$store.state.singables.id" > 0 </VehicleSong>
    <router-link class="btn-to-jungle" to="/jungle">Check out the animals here</router-link>
  </div>
</template>

<script>
import VehicleSong from '@/components/VehicleSong.vue'

export default {
  name: 'Jeep',
  components: {
    VehicleSong
  }
}
</script>

<style>
img {
    width: 300px;
}

.btn-to-jungle {
  background-color: lightsalmon;
  font-weight: bold;
  font-size: 20px;
  margin: 50px 30px;
  margin-top: 50px;
  padding: 20px 30px;
  border-radius: 10px;
  text-decoration: none;
  box-shadow: 2px 2px 4px black;
}

vehicle-song {
  margin-bottom: 50px;
}

</style>