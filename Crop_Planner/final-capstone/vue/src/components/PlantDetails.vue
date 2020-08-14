<template>
  <div id="main-plant-details" v-if="this.$store.state.vegetable.id > 0">
    <div class="attribute">
      <h4 class="plants-detail-categories">Selected Plant</h4>
      <h2 id="plant-name">{{this.$store.state.vegetable.name}}</h2>
    </div>
    <div class="attribute">
      <p id="plant-description" class="plants-details">{{this.$store.state.vegetable.description}}</p>
      <br>
    </div>
    <div class="attribute">
      <h4 class="plants-detail-categories">Plants Per Square Foot</h4>
      <p
        id="plant-description"
        class="plants-details"
      >{{this.$store.state.vegetable.plantsPerSqFoot}}</p>
    </div>
    <div class="attribute" >
      <h4 class="plants-detail-categories">Sun Requirements</h4>
      <p
        id="plant-description"
        class="plants-details"
      >{{this.$store.state.vegetable.sunRequirements == null ? 'Unknown' : this.$store.state.vegetable.sunRequirements}}</p>
    </div>
    <div class="attribute">
      <h4 class="plants-detail-categories">
        Seedling Cost Each / Per Ft
        <sup>2</sup>
      </h4>
      <p
        id="plant-description"
        class="plants-details"
      >$ {{this.$store.state.vegetable.seedlingCost}} / $ {{this.$store.state.vegetable.seedlingCost * this.$store.state.vegetable.plantsPerSqFoot}}</p>
    </div>
    <div class="attribute">
      <img id="plant-details-image" v-bind:src="require('../img/vegetables/' + this.$store.state.vegetable.name + '.png')"/>
    </div>
  </div>

  <div id="main-plant-details" v-else>
    <h2
      id="plant-name" class="disclaimer"
    >Select a Plant to Assign it to the Selected Plot(s)</h2>
    
  </div>
</template>

<script>
export default {
  name: "plant-details",
};
</script>

<style>
#main-plant-details {
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
  padding: 25px 0px;
  font-size: 1.3em;
}

.disclaimer {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  align-content: center;
  justify-items: center;
}

#plant-name {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  text-align: center;
  margin: 0px;
  font-size: 1.5em;
}

#plant-details-image {
  width: 40%;
}

.attribute {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 8px;
}
.plants-detail-categories,
.plants-details {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  text-align: center;
  font-size: 0.8em;
  font-weight: 200;
  margin-top: 0px;
  margin-bottom: 3px;
  width: 90%;
}
.plants-detail-categories {
  color: black;
}
.plants-details {
  margin-top: 5px;
  font-size: 0.9em;
}
</style>