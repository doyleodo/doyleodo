<template>
  <div id="main-garden-container">
         <div id="garden-title-button-container">
           <h1 id="garden-name">{{this.$store.state.garden.gardenName}}</h1>
          <a
          class="btn-garden btn-shopping-list"
          href="#"
          v-on:click.prevent="goToShopping()"
        >Go to {{this.$store.state.garden.gardenName}}'s Shopping List</a>
           </div>




        <div class="plant-garden-container">
          <plant-details class="plant-details" />
          <garden-details class="garden-details" />
        </div>
        
        <plant-list />

    </div>
</template>

<script>
import GardenDetails from '@/components/GardenDetails'
import PlantList from '@/components/PlantList'
import PlantDetails from '@/components/PlantDetails'

export default {
  components: {
    GardenDetails,
    PlantList,
    PlantDetails
  },

methods: {
    goToShopping() {
          this.$router.push({
              name: "shopping",
              params: { gardenid: this.$route.params.gardenid }
            });
          }
},
}
</script>

<style>
#main-garden-container {
  display: flex;
  flex-direction: column;
  width: 95%;
  align-content: center;
}

#garden-title-button-container {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  align-items: baseline;
  margin-top: 0px;
  margin-bottom: 0px;
  margin-right: 3px;
}

#garden-name {
  display: flex;
  width: 75%;
  flex-grow: 1;
  justify-content: flex-start;
}

.plant-garden-container {
  display: flex;
  flex-grow: 1;
  justify-content: space-between;
  width: 100%;
}

.plant-details {
  display: flex;
  flex-direction: column;
  align-content: center;
  margin-right: 20px;
  width: 25%;
  color: white;
  background-color: #307c55;
  border: 1px solid #307c55;
  border-radius: 25px;
}
.garden-details {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-items: center;
  width: 70%;
  color: white;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 25px;
  padding: 20px;
}

.btn-shopping-list {
  display: flex;
  color: white;
  text-align: center;
  align-items: center;
  border-radius: 15px;
  height: 2em;
  font-size: 1.1em;
  font-weight: 700;
  text-decoration: none;
  border-style: solid;
  padding: 0 40px;
  background-color: #307c55;
  border-color: #307c55;
}

.btn-garden {
    box-shadow: 2px 2px 4px black;
}

</style>