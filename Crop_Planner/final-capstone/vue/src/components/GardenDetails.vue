<template>
  <form id="garden-grid-form">
    <div id="gridView">
      <div class="row" v-for="i in rowCount" v-bind:key="i">
        <div class="squares" v-for="plot in itemCountInRow(i)" v-bind:key="plot.id">
          
          <div class="inner">
            <input
              class="check"
              type="checkbox"
              v-bind:id="plot.plotNumber"
              v-on:change="selectPlot($event)"
              v-bind:checked="selectedPlots.includes(plot.plotNumber)"
            />
            <img class="plot-plant-image" v-bind:src="require('../img/vegetables/' + plot.plantId + '.png')"/>
            <p class="garden-plot-numbers">{{plot.plotNumber}}</p>
            <p class="garden-plot-numbers">{{plot.plantId}}</p>
          </div>

        </div>
      </div>
    </div>

    <div class="button-container">
      
        <a
          class="btn-update btn-garden"
          v-if="this.$store.state.vegetable.name != null && this.selectedPlots != ''"
          href="#"
          v-on:click.prevent="assignVegetableToPlots()"
        >Assign {{this.$store.state.vegetable.name}} to the Selected Plot{{this.selectedPlots.length > 1 ? 's' : ''}}</a>
        
        <a
          class="btn-update btn-garden dead-button"
          v-else
          href="#"
        >Select Plot(s) and Plant to Activate this Button</a>

        <a
          class="btn-save-garden btn-garden"
          v-if="this.updatesMade"
          href="#"
          v-on:click.prevent="saveUpdates()"
        >Save Changes to Garden and Generate Shopping List</a>

        <a
          class="btn-save-garden btn-garden dead-button"
          v-else
          href="#"

        >Save Changes to Garden and Generate Shopping List</a>        

      
    </div>
      </form>
</template>

<script>
import GardenService from "@/services/GardenService";
import PlotService from "@/services/PlotService";

export default {
  name: "garden-details",

  data() {
    return {
      itemsPerRow: 0,
      updatesMade: false,

      plot: {
        plotNumber: 0,
        gardenId: this.$route.params.gardenid,
        plantId: 1,
      },
      selectedPlots: [],
      plotList: [],
      plotArray: "",
      assignedPlotArray: [],
    };
  },
  created() {
    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);
        this.itemsPerRow = this.$store.state.garden.gardenWidth;
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });

    PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        if (
          response.data.length ===
          this.$store.state.garden.gardenWidth *
            this.$store.state.garden.gardenLength
        ) {
          this.$store.commit("SET_PLOTS", response.data);
          this.plotArray = response.data;
        } else {
          this.loadArray();
        }
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
  },

  computed: {
    rowCount: function () {
      return Math.ceil(this.plotArray.length / this.itemsPerRow);
    },
  },
  methods: {
    itemCountInRow: function (index) {
      return this.plotArray.slice(
        (index - 1) * this.itemsPerRow,
        index * this.itemsPerRow
      );
    },

    selectPlot(event) {
      if (event.target.checked) {
        this.selectedPlots.push(parseInt(event.target.id));
      } else {
        this.selectedPlots = this.selectedPlots.filter((plot) => {
          return plot !== parseInt(event.target.id);
        });
      }
    },
    assignVegetableToPlots() {
      this.selectedPlots.forEach((id) => {
        this.plotArray.forEach((plot) => {
          if (plot.plotNumber == id) {
            plot.plantId = this.$store.state.vegetable.id;
          }
        });
      });
      this.selectedPlots = [];
      this.updatesMade = true;
    },

    saveUpdates() {
      this.assignVegetableToPlots;
      
      PlotService.saveGardenPlots(this.plotArray, this.$route.params.gardenid)
        .then((response) => {
          if (response.status == 200) {
            this.plotArray = response.data;
            this.$store.commit("SET_PLOTS", response.data);
            //add router push potentially
             this.$router.push({
              name: "shopping",
              params: { gardenid: this.$route.params.gardenid },
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

    loadArray() {
      var x = 1;
      let plotsNum =
        this.$store.state.garden.gardenWidth *
        this.$store.state.garden.gardenLength;
      this.plotArray = new Array();
      for (var i = 0; i < plotsNum; i++) {
        let plot = {
          plotNumber: x++,
          gardenId: this.$route.params.gardenid,
          plantId: 1,
        };
        this.plotArray.push(plot);
      }
    },
  },
};
</script>

<style scoped>

.garden-plot-numbers {
  display: none;
}

.plot-plant-image {
  width: 50px;
  margin: 0px 10px 20px 0px;
}

.garden-grid-form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

#gridView {
  margin: 0 auto;
  font-size: 1rem;
  border-radius: 20px;
  background-color: #381c06;
}
.row {
  display: flex;
}
.squares {
  width: 150px;
  margin: 5px;
  color: white;
  font-weight: bold;
  flex: 1 0 auto;
  position: relative;
  background-color: rgb(165, 112, 42);
  border: 2px;
  border-style: solid;
  border-color: #381c06;
}
.squares::after {
  content: "";
  float: left;
  display: block;
  padding-top: 100%;
}
.squares .inner {
  position: absolute;
  left: 5px;
  right: -15px;
  bottom: -20px;
  top: 0;
  display: flex;
  align-items: center;
  justify-content: center;
}


.check {
  position: absolute;
   left: 0;
  right: 25px;
  bottom: 25px;
  top: 0px;
  align-content: center;
  justify-content: center;
  width: 15px;
  height: 15px;
} 

.button-container {
  display: flex;
  flex-grow: 1;
  width: 100%;
  justify-content: center;
  align-items: center;
  height: 2em;
  margin-top: 40px;
  margin-bottom: 20px;
}

.btn-garden {
  display: flex;
  flex-grow: 1;
  align-items: center;
  text-align: center;
  border-radius: 15px;
  line-height: 1.7em;
  width: 300px;
  height: 4em;
  color: #fff;
  font-size: 1.1em;
  margin: 20px;
  padding: 0px 20px;
  text-decoration: none;
  border-style: solid;
}

.btn-update {
  background-color: #e48438;
  border-color: #e48438;

}
.btn-update:hover,
.btn-save-garden:hover {
  background-color: #e48438;
  border-color: #e48438;

}

.btn-save-garden {
  background-color: #307c55;
  border-color: #307c55;

}

.dead-button,.dead-button:hover {
  padding: 0 15px;
  background-color: #696866;
  border-color: #696866;
    box-shadow: none;

}

</style>