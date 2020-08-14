<template>
  <div class="shopping-list-container">
    <div class="plant-list-items">
        <h3>Plant Items:</h3>
        <ul class="plant-costs">
           <li class="field-headings"><span class="itemNameField">Item Name</span> <span class="itemQuantityField">Qty.</span> <span class="itemCostField">Each</span> <span class="itemCostField">Total</span></li>
            <li class="line-items" v-for="list in this.$store.state.seedlingShoppingLists" v-bind:key="list.index"><span class="itemNameField">{{list.itemName}} Seedling</span> <span class="itemQuantityField">{{list.itemQuantity}}</span> <span class="itemCostField">{{ (list.cost/list.itemQuantity) | currency}}</span> <span class="itemCostField">{{list.cost | currency}}</span></li>
                     <li class="field-headings total-line"><span class="itemNameField">Plant Total</span> <span class="itemQuantityField"></span> <span class="itemCostField"></span> <span class="itemCostField">{{totalSupplyCost | currency}}</span></li>
        </ul>
      </div>

  </div>
</template>

<script>
import PlotService from "@/services/PlotService";
import ShoppingService from "@/services/ShoppingService.js";
import GardenService from "@/services/GardenService";


export default {
  name: "plant-shopping-list",
  data() {
    return {
      PlotsLoaded: false,
      plotList: this.$store.state.plots,
      ShoppingLists: [{
        cost: 0,
        itemName: '',
        itemQuantity: '',
      }],
    };
  },

  created() {
    PlotService.getPlotsByGardenId(this.$route.params.gardenid)
      .then((response) => {
        this.plotList = response.data;
        this.$store.commit("SET_PLOTS", response.data);
        this.PlotsLoaded = true;

        ShoppingService.generateSeedlingShoppingList(this.$route.params.gardenid)
          .then((response) => {
            this.ShoppingLists = response.data;
            this.ShoppingLists.forEach((plant) => {
                 this.$store.commit("SET_SEEDLING_SHOPPING_LISTS", plant);
          });

          })
          .catch((error) => {
            if (error.response && error.response.status === 404) {
              alert("Shopping List Data not available.");
              this.$router.push("/");
            }
          });

      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });

    GardenService.getGardenById(this.$route.params.gardenid)
      .then((response) => {
        this.$store.commit("SET_GARDEN", response.data);
        console.log(this.String);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
  },

computed: {
 totalSupplyCost() {
          var total = 0;
          this.$store.state.seedlingShoppingLists.forEach(item => {
            total += item.cost;
          });
          return total;
      },
}
}
</script>

<style>
#plant-list-items, h3 {
display: flex;
justify-content: flex-start;
text-justify: left;
margin-bottom: 0px;
}

.plant-costs {
  margin-top: 3px;
}

.field-headings {
  font-family: 'Kameron', serif;
  font-weight: 700;
  display: flex;
  margin-top: 0px;
}

.line-items {
  font-family: 'Kameron', serif;
  font-weight: 100;
  display: flex;
}

.itemNameField {
  width: 200px;
  text-align: left;
  word-wrap: none;

}
.itemQuantityField {
  width: 70px;
  text-align: right;
}
.itemCostField {
  width: 120px;
  text-align: right;
}


</style>