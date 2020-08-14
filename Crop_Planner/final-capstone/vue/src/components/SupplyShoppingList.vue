<template>
  <div class="shopping-list-container">
    <div class="plant-list-items">
        <h3>Supply/Tool Items:</h3>
        <ul class="plant-costs">
           <li class="field-headings"><span class="itemNameField">Item Name</span> <span class="itemQuantityField">Qty.</span> <span class="itemCostField">Each</span> <span class="itemCostField">Total</span></li>
            <li class="line-items" v-for="list in this.$store.state.shoppingLists" v-bind:key="list.supplyId"><span class="itemNameField">{{list.supplyName}}</span> <span class="itemQuantityField">{{list.supplyQty}}</span> <span class="itemCostField">{{ (list.cost/list.supplyQty) | currency}}</span> <span class="itemCostField">{{list.cost | currency}}</span></li>
            <li class="field-headings total-line"><span class="itemNameField">Supply/Tool Total</span> <span class="itemQuantityField"></span> <span class="itemCostField"></span> <span class="itemCostField">{{totalSupplyCost | currency}}</span></li>
        </ul>
        <h3 class="grandTotalHeading">Grand Total:<span class="grandTotalCostField">{{grandTotalCost | currency}}</span></h3>
      </div>
  </div>
</template>

<script>
import ShoppingService from "@/services/ShoppingService";

export default {
   created() {
  
    ShoppingService.getShoppingLists(this.$route.params.gardenid)
      .then((response) => {
        response.data.forEach(list => {
           this.$store.commit("SET_SHOPPING_LISTS", list);
        })
       
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Shopping List Data not available.");
          this.$router.push("/");
        }
      });




   },
  name: "supply-shopping-list",
  
  computed: {
      totalSupplyCost() {
          var total = 0;
          this.$store.state.shoppingLists.forEach(item => {
            total += item.cost;
          });
          return total;
      },

      grandTotalCost() {
          var total = 0;
          this.$store.state.seedlingShoppingLists.forEach(item => {
            total += item.cost;
          });
          this.$store.state.shoppingLists.forEach(item => {
            total += item.cost;
          });
          return total;
      },


  },
  data() {
    return {
      PlotsLoaded: false,
      plotList: this.$store.state.plots,
      ShoppingLists: '',
    };
  },
}
</script>

<style>
#plant-list-items, h3 {
display: flex;
justify-content: flex-start;
text-justify: left;
width: 100%;
margin-bottom: 0px;
}

.plant-costs {
  margin-top: 3px;
}

.field-headings {
  font-family: 'Kameron', serif;
  font-weight: 700;
  display: flex;
    font-size: 1.2em;
  margin-top: 0px;
}

.line-items {
  font-family: 'Kameron', serif;
  font-weight: 100;
  font-size: 1.2em;
  display: flex;
}

.total-line {
  margin-top: 10px;
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

.grandTotalCostField {
  display: flex;
  flex-grow: 1;
  justify-content: flex-end;
  text-justify: right;
  color: black;
  
}
.grandTotalHeading {
  display: flex;
  flex-grow: 1;
  width: 100%;
}


</style>