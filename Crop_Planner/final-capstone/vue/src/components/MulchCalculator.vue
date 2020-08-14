<template>
  <form id="mulch-supply-selector">

    <div id="supplies">
          <h2>Mulch Calculator</h2>
    <h3>Select a Mulch Type</h3>
      <div class="supply" v-for="supply in this.Mulches" v-bind:key="supply.index">
        <input
          type="radio"
          class="checkboxes"
          name="mulch"
          v-bind:id="supply.supplyId"
          v-bind:value="supply.supplyId"
          v-on:change="selectSupply($event)"
        />
        <label v-bind:for="`Supply-${supply.supplyId}`">{{supply.supplyName.substring(mulchFilter.length)}} <span class="mulch-cost">{{ supply.supplyCost | currency }}/sf</span></label>
      </div>
    </div>
  <div id="supplies">
    <h3>Set Desired Mulch Thickness (Inches)</h3>
    <input 
    id="mulch-thickness-box"
    type="number"
    min="1"
    max="4"
    v-model="mulchThickness">

</div>
 <div id="supplies">
    <h3>Mulch Required</h3>
    <h3>{{mulchRequired}} Bags</h3>
    <h3>{{mulchCost | currency}} Total</h3>
</div>


<div class="center-it">
        <a
          href="#"
          class="btn-add-mulch-to-list"
          v-if="selectionMade"
          v-on:click.prevent="addMulchToShoppingList()"
        >Add Mulch to Shopping List</a>
        <a
          href="#"
          class="btn-add-mulch-to-list-dead"
          v-else
        >Add Mulch to Activate</a>
      </div>
  </form>
</template>

<script>
import SupplyService from "../services/SupplyService";
import ShoppingService from "@/services/ShoppingService";

export default {
  created() {
    SupplyService.getAllSupplies()
      .then((response) => {
        this.Supplies = response.data;
        this.Mulches = this.Supplies.filter((item) => {
        return item.supplyName.toLowerCase().includes(this.filterString.toLowerCase());
        });
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Supply data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "mulch-calculator",
  components: {},
  data() {
    return {
      ShoppingList: {
        cost: 0,
        supplyName: '',
        supplyQty: '',
        supplyId: "",
      },
      Supplies: [{
        supplyId: "",
        supplyName: "",
        supplyCost: "",
        supplyQty: "",
       }],
       Mulches: [{
        supplyId: "",
        supplyName: "",
        supplyCost: "",
        supplyQty: "",
       }],
       selectionMade: false,
       selectedMulch: "",
       filterString: "bagged",
       mulchFilter: "2 cu ft. Bagged ",
       mulchThickness: 2,
    };
  },
  computed: {
      mulchRequired() {
          return Math.ceil(((this.mulchThickness/12) * (this.$store.state.garden.gardenWidth * this.$store.state.garden.gardenLength))/2);
      },
      mulchCost() {
          return this.mulchRequired * 4.5;
          
      }
  },
  methods: {
    selectSupply(event) {
      this.selectionMade = true;
      if (event.target.checked) {
      this.selectedMulch = (this.Mulches.filter(
          (supply) => {
            if (supply.supplyId == event.target.value) {
              return supply;
            }
          }
        ));
      }
    },
 
    addMulchToShoppingList() {
      this.ShoppingList.cost = this.mulchCost;
      this.selectedMulch.forEach(element => {
        this.ShoppingList.supplyName = element.supplyName;
        this.ShoppingList.supplyId = element.supplyId;
        });
      this.ShoppingList.supplyQty = this.mulchRequired;
      this.$store.commit('SET_SHOPPING_LISTS', this.ShoppingList);
                    ShoppingService.addItemToList(this.ShoppingList, this.$route.params.gardenid)
                      .then()
                      .catch((error) => {
                        const response = error.response;

                        if (response.status === 401) {
                          this.invalidCredentials = true;
                        }
                      });



      }


  }






}

</script>

<style local>
#mulch-supply-selector {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-items: space-between;
  flex-grow: 1;
  margin-top: 25px;
}

#mulch-thickness-box {
  font-size: 1.5em;
  font-weight: 700;
  margin-bottom: 40px;
}

#supplies {
  display: flex;
  flex-direction: column;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 40px;
}

.supply {
  display: flex;
  width: 40ch; 
  align-items: center;
  margin: 3px 3px;
  color: black;
  font-weight: 700;
  background-color: #c1c56d;
  border: 1px solid #c1c56d;
  border-radius: 5px;

}

.supply label {
  margin: 0px;
  padding-left: 5px;
  width: 50ch;
  display: flex;
  justify-content: space-between;
}
.checkboxes {
  width: 13px;
  margin-bottom: 5px;
}

.mulch-cost {
  padding-right: 20px;  
}
.center-it {
  display: flex;
  justify-content: center;
  align-items: flex-end;
  text-justify: center;
  width: 100%;
  flex-grow: 1;
}
.btn-add-mulch-to-list {
  display: flex;
  justify-content: center;
  width: 80%;
  height: 2em;
  background-color: #e48438;
  border-color: #e48438;
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

.btn-add-mulch-to-list-dead {
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
