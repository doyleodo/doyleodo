<template>
  <form id="garden-add-garden" v-on:submit.prevent="addNewGarden">
    <h1>Add New Garden</h1>

    <div class="form-element">
      <label for="name">Garden Name:</label>
      <input id="name" type="text" v-model="newGarden.gardenName" />
    </div>

    <div class="form-element">
      <label for="width">Garden Width in Feet:</label>
      <input
        id="width"
        type="number"
        min="1"
        v-on:change="changeSize"
        v-model="newGarden.gardenWidth"
      />
    </div>

    <div class="form-element">
      <label for="length">Garden Length in Feet:</label>
      <input
        id="length"
        type="number"
        min="1"
        v-on:change="changeSize"
        v-model="newGarden.gardenLength"
      />
    </div>

    <div id="gridView">
      <div class="rowz" v-for="i in rowCount" v-bind:key="i">
        <span
          class="squares"
          v-for="plot in itemCountInRow(i)"
          v-bind:key="plot"
        >{{plot.plotNumber}}</span>
      </div>
    </div>

    <div class="actions-buttons-x">
      <a href="#" class=" btn-cancel-x btn-x-btn" v-on:click.prevent="resetForm" type="cancel">Cancel</a>
      <a v-on:click.prevent="addNewGarden" class=" btn-submit-x btn-x-btn" type="submit" >Submit</a>
    </div>
  </form>
</template>

<script>
import GardenService from "@/services/GardenService";

export default {
  name: "add-garden",
  data() {
    return {
      newGarden: {
        userId: this.$store.state.userData.id,
        gardenId: 0,
        gardenName: "",
        gardenWidth: 2,
        gardenLength: 2
      },

        sizeArray: [
          {
            plotNumber: 1,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 2,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 3,
            gardenId: 0,
            vegetableId: 0,
          },
          {
            plotNumber: 4,
            gardenId: 0,
            vegetableId: 0,
          }
        ],
      
    };
  },

  computed: {
    rowCount() {
      return Math.ceil(this.sizeArray.length / this.newGarden.gardenWidth);
    }
  },

  methods: {
    itemCountInRow(index) {
      return this.sizeArray.slice(
        (index - 1) * this.newGarden.gardenWidth,
        index * this.newGarden.gardenWidth
      );
    },
    addNewGarden() {
      GardenService.addGarden(this.newGarden)
        .then((response) => {
          if (response.status == 200) {
            this.newGarden.gardenId = response.data.gardenId;
            this.$store.commit("ADD_GARDEN", response.data);
            this.$router.push({
              name: "garden",
              params: { gardenid: this.newGarden.gardenId },
            });
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    resetForm() {
      this.newGarden.gardenName = "";
      this.newGarden.gardenWidth = 2;
      this.newGarden.gardenLength = 2;
      this.newGarden.sizeArray = [
        [1, 2],
        [3, 4],
      ];
    },
    changeSize() {
      var x = 1;
      let plotsNum = this.newGarden.gardenWidth * this.newGarden.gardenLength;
      this.sizeArray = new Array();
      for (var i = 0; i < plotsNum; i++) {
        let plot = {
          plotNumber: x++,
          gardenId: 0,
          vegetableId: 0,
        };
        this.sizeArray.push(plot);
      }
    }
  }
};
</script>

<style >
#garden-add-garden {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  flex-grow: 1;
}

#gridView {
display: flex;
flex-direction: column;
flex-grow: 1;
  width: fit-content;
  justify-content: center;
  align-items: center;
  padding: 20px;
  border-radius: 20px;
  background-color: #381c06;
  margin: 20px;
}

input {
  width: 5ch;
  font-size: 1.1em;
}

#name {
  width: 20ch;
}

.rowz {
  display: flex;
  flex-grow: 1;
  width: 100%;
  justify-content: center;
}

.squares  {
  width: 100px;
  height: 100px;
  display: flex;
  flex-grow: 1;
  align-items: center;
  justify-content: center;
  min-height: 50px;
  max-height: 100px;
  min-width: 50px;
  max-width: 100px;
  text-align: center;
  background-color: rgb(165, 112, 42);
  border: 2px;
  border-style: solid;
  border-color: #381c06;
}

.actions-buttons-x {
  display: flex;
  flex-grow: 1;
  width: 100%;
  justify-content: space-between;
}

.btn-x-btn {
  display: flex;
  flex-grow: 1;
  color: white;
  text-align: center;
  align-items: center;
  border-radius: 15px;
  line-height: 1.7em;
  height: 2em;
  font-size: 1.1em;
  font-weight: 700;
  text-decoration: none;
  border-style: solid;
  padding: 0 40px;
  background-color: #307c55;
  border-color: #307c55;
  box-shadow: 2px 2px 4px black;
  margin: 20px;
}
.btn-cancel-x {
  background-color: #e48438;
    border-color: #e48438;
}
.btn-submit-x {
  background-color: #307c55;
}



</style>