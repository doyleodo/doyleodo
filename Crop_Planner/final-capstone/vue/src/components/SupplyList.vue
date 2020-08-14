<template>
  <form id="supply-selector">
    <h2>Supplies and Tools</h2>
    <h3>Select Items to Add to Your List</h3>
    <div id="supplies-items">
      <div class="supply-item" v-for="supply in this.FilteredSupplies" v-bind:key="supply.index">
        <input
          type="checkbox"
          class="checkboxes"
          v-bind:id="`Supply-${supply.supplyId}`"
          v-bind:value="supply.supplyId"
          v-on:change="selectSupply($event)"
        />
        <label v-bind:for="`Supply-${supply.supplyId}`">
          {{supply.supplyName}}
          <span class="mulch-cost">{{ supply.supplyCost | currency }}</span>
        </label>
      </div>

    </div>

    <div class="center-it">
      <a
        href="#"
        class="btn-add-item-to-list"
        v-if="selectionMade"
        v-on:click.prevent="addItemsToShoppingList()"
      >Add Selections to Shopping List</a>
      <a href="#" class="btn-add-item-to-list-dead" v-else>Add Selection to Activate</a>
    </div>
   </form>
</template>

<script>
import SupplyService from "../services/SupplyService";
import ShoppingService from "../services/ShoppingService";

export default {
  created() {
    SupplyService.getAllSupplies()
      .then((response) => {
        this.Supplies = response.data;
        this.FilteredSupplies = this.Supplies.filter((item) => {
          return !item.supplyName
            .toLowerCase()
            .includes(this.filterString.toLowerCase());
        });
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Supply data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "supply-data",
  components: {},
  data() {
    return {
      supply: {
        supplyId: "",
        supplyName: "",
        supplyCost: "",
        supplyQty: "",
      },
      ShoppingLists: [],
     
      FilteredSupplies: [
        {
          supplyId: "",
          supplyName: "",
          supplyCost: "",
          supplyQty: "",
        },
      ],
      selectionMade: false,
      selectedSupplies: [],
      filterString: "bagged",
    };
  },

  methods: {
     selectSupply(event) {
      this.selectionMade = true;
      this.FilteredSupplies.forEach(
          (supply) => {
            if (supply.supplyId == event.target.value) {
              this.selectedSupplies.push(supply);
            }
          });
      }, 
    
    
    addItemsToShoppingList() {
      this.selectedSupplies.forEach((item) => {
            let shoppingListItem = {cost: '', itemName: '', supplyQty: '', supplyId: '' };
                shoppingListItem.cost = item.supplyCost;
                shoppingListItem.supplyName = item.supplyName;
                shoppingListItem.supplyId = item.supplyId
                shoppingListItem.supplyQty = 1;
                this.$store.commit("SET_SHOPPING_LISTS", shoppingListItem);

             
                    ShoppingService.addItemToList(shoppingListItem, this.$route.params.gardenid)
                      .then()
                      .catch((error) => {
                        const response = error.response;

                        if (response.status === 401) {
                          this.invalidCredentials = true;
                        }
                      });
          });
      this.selectedSupplies = [];
     },
  }

 };
</script>

<style>
#supply-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 25px;
  flex-grow: 1;
  height: fit-content;
}

#supplies-items {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  flex-wrap: wrap;
  height: 50%;
  width: 100%;
  max-width: 100%;
  justify-content: flex-start;
  align-items: center;
  margin: 50px 0 0 0;

}

.supply-item {
  display: flex;
  width: 48%;
  align-items: center;
  margin: 3px 3px;
  color: #307c55;
  font-weight: 700;
  background-color: white;
  border: 1px solid white;
  border-radius: 5px;
}

.supply-item > label {
  margin: 0px;
  padding-left: 5px;
  width: 50ch;
  display: flex;
  justify-content: space-between;
  text-align: left;
}
.supply > .checkboxes {
  width: 20px;
  margin-bottom: 5px;
}

.btn-add-item-to-list {
  display: flex;
  justify-content: center;
  width: 80%;
  height: 2em;
  background-color: #307c55;
  border-color: #307c55;
  color: #fff;
  text-align: center;
  border-radius: 15px;
  line-height: 1.7em;
  font-size: 1.2em;
  text-decoration: none;
  border-style: solid;
  margin: 0px 10px;
  padding: 15px;
}
.btn-add-item-to-list-dead {
  display: flex;
  justify-content: center;
  width: 80%;
  height: 2em;
  background-color: #696866;
  border-color: #696866;
  color: #fff;
  text-align: center;
  border-radius: 15px;
  line-height: 1.7em;
  font-size: 1.2em;
  text-decoration: none;
  border-style: solid;
  margin: 0px 10px;
  padding: 15px;
}
</style>
