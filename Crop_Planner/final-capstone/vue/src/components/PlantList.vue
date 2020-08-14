<template>
  <form id="plant-selector-garden">
    <div id="plants-garden">
      <div class="plant-garden" v-for="plant in this.$store.state.plants" v-bind:key="plant.index">
        <input
          type="radio"
          name="veggie"
          class="radios"
          v-bind:id="`Plant-${plant.id}`"
          v-bind:value="plant.id"
          v-on:change="selectVegetable($event)"
        />
        <img class="plantimg-garden" v-bind:src="require('../img/vegetables/' + plant.name + '.png')"/>        
        <label v-bind:for="`Plant-${plant.id}`">{{plant.name}}</label>
      </div>
    </div>
  </form>
</template>

<script>
import PlantService from "../services/PlantService";

export default {
  created() {
    PlantService.getAllPlants()
      .then((response) => {
        this.$store.commit("SET_PLANTS", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Plant data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "plant-data",
  components: {},
  data() {
    return {
      vegetable: {
        id: "",
        name: "",
        description: "",
        plantsPerSqFoot: "",
        sunRequirements: "",
        region: "",
        seedlingCost: "",
      },
    };
  },
  methods: {
    selectVegetable(event) {
      if (event.target.checked) {
        this.vegetable.description = this.$store.state.plants.filter(
          (plant) => {
            if (plant.id == event.target.value) {
              this.vegetable = plant;
              this.$store.commit("SET_VEGETABLE", this.vegetable);
            }
          }
        );
      } else {
        this.vegetable = null;
      }
    },
  },
};
</script>

<style>

#plant-selector-garden {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#plants-garden {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  height: 25vh;
  width: 90%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: center;
}

.plant-garden {
  display: flex;
  width: 19ch;
  align-items: center;
  margin: 3px 3px;
  background-color: white;
  border: 1px solid white;
  border-radius: 5px;

}

.plantimg-garden {
  display: flex;
  width: 35px;
  align-items: center;
  margin: 3px 3px;

}

.plant label {
  margin: 0px;
}
.radios {
  width: 13px;
  margin-bottom: 5px;
}
</style>
