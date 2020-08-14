<template>
  <form id="plant-selector" class ="plant-container profile-details bubble-block"
  v-on:submit.prevent="submitForm">
    <div id="plants">
      <div class="plant" v-for="plant in this.$store.state.plants" v-bind:key="plant">
        <input
          type="radio"
          name="veggie"
          class="radios"
          v-bind:id="`Plant-${plant.id}`"
          v-bind:value="plant.id"
          v-on:change="selectVegetable($event)"
        />
        <img id="admin-plant-image" v-bind:src="require('../img/vegetables/' + plant.name + '.png')"/>
        <label v-bind:for="`Plant-${plant.id}`">{{plant.name}}</label>
      </div>
    </div>
    <div class="plant-button-container">
      <button class="btn-edit btn-profile" v-on:click.prevent="addPlant" type="submit">Add New Plant</button>
      <button class="btn-edit btn-profile" v-if="this.vegetable.id > 0" v-on:click.prevent="editPlant" type="edit">Edit Plant</button>
      <button class="btn-delete btn-profile" v-on:click.prevent="deletePlant">Delete Plant</button>
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
    editPlant(){
        this.$router.push({ name:"edit-plant", params: {plantid: this.vegetable.id}});
    },
    addPlant(){
        this.$router.push(`/admin/addplant`);
    },
        deletePlant() {
      if (
        confirm(
          "Are you sure you want to delete this plant? This action cannot be undone."
        )
      ) {
        PlantService
          .deletePlant(this.vegetable.id)
          .then(response => {
            if (response.status === 200) {
              alert("Plant successfully deleted");
              this.$router.go();
            }
          })
          .catch(error => {
            if (error.response) {
              this.errorMsg =
                "Error deleting plant. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting plant. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting plant. Request could not be created.";
            }
          });
      }
    }
  },
};
</script>

<style local>

#admin-plant-image {
width: 60px;
}

#plant-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 25px;
}

#plants {
  display: flex;
  flex-direction: row;
  height: 30vh;
  width: 90%;
  flex-wrap: wrap;
  justify-content: flex-start;
  align-items: center;
}

.plant {
  display: flex;
  width: 18ch;
  align-items: center;
  /* margin: 3px 3px;
  background-color: #85a183;
  border: 1px solid #85a183;
  border-radius: 5px; */

}

.plant label {
  margin: 0px;
}
.radios {
  width: 13px;
  margin-bottom: 5px;
}


h2 {
  margin-bottom: 10px;
}
.bubble-block {
  display: flex;
  flex-direction: column;
  padding: 0px 30px 15px;
  align-content: center;
  border-radius: 25px;
  margin-bottom: 30px;
}

.profile-details {
  background-color: white;
  border: 1px solid white;
}

.garden-listing {
  background-color:  #e48438;
  border: 1px solid  #e48438;
}

.profile-field {
  display: flex;
  margin: 3px 0px;
}

.label-field {
  width: 14ch;
}
.button-container {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  margin-top: 20px;
}

.btn-profile {
  color: #fff;
  text-align: center;
  width: 150px;
  border-radius: 15px;
  line-height: 1.7em;
  font-size: 1.1em;
  text-decoration: none;
  border-style: solid;
  margin: 0px 10px;
}

.btn-edit, .btn-add-garden:hover {
  background-color: #85a183;
  border-color: #85a183;

}
.btn-delete {
  background-color: #e48438;
  border-color: #e48438;
}
.btn-delete:hover {
  background-color: black;
  border-color: black;
}

.btn-add-garden, .btn-edit:hover, .garden-links:hover {
  color: white;
  background-color: #307c55;
  border-color: #307c55;
}

.garden-links {
  display: inline-block;
  color: black;
  text-decoration: none;
  padding: 2px 10px;
  margin: 3px 6px;
  background-color: #c1c65d;
  border: 1px solid #c1c65d;
  border-radius: 5px;
}

.plant-container {
    background-color: #307C55;
}

.plant-button-container {
  margin-top: 100px;
  
  
}

</style>