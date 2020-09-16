<template>
  <div>
    <img src="../assets/submarine.jpg" alt="">
    <VehicleSong> v-if="this.$store.state.singables.id" > 0 </VehicleSong>
  </div>
</template>

<script>
import VehicleSong from '@/components/VehicleSong.vue'

export default {
  name: 'Submarine',
  components: {
    VehicleSong
  }
}
</script>

<style>
img {
    width: 300px;
}
</style>