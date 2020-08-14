<template>
  <div> 
      <router-link
        tag="button"
        :to="{ name: 'EditPlot', params: {plotID: $route.params.plotID} }"
        class="btn editPlot"
      >Edit Plot</router-link>
      <button class="btn deletePlot" v-on:click="deletePlot">Delete Plot</button>
      <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>

      <div class="garden-actions">
      <router-link :to="{ name: 'Garden', params: { id: $route.params.gardenID } }">Back to Garden</router-link>
    </div>
    </div>
</template>

<script>
export default {

}
</script>

<style>

</style>