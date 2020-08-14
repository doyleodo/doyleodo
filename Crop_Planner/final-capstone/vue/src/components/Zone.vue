<template>
  <div class="page">
    
    <div class="map">
      <div>
          <h3 class="description">The Plant Hardiness Zone is a standard that gardeners use to determine which plants are most likely to thrive at a given location.    The hardiness zone of your region is determined by the average annual extreme minimum temperature</h3>
          <h3 class="description">It's important to know which zone your garden is in before deciding which vegetables to grow.  Use the guide below to see which plants are best suited for your Hardiness Zone.</h3>
        <h1>Your Plant Hardiness Zone</h1>
          <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-if="this.$store.state.userData.region == '3a' || this.$store.state.userData.region == '3b'">
          <img class="zonemap" src="../img/zonemaps/zone4.png" alt="grow zones map" v-if="this.$store.state.userData.region == '4a' || this.$store.state.userData.region == '4b'">
          <img class="zonemap" src="../img/zonemaps/zone5.png" alt="grow zones map" v-if="this.$store.state.userData.region == '5a' || this.$store.state.userData.region == '5b'">
          <img class="zonemap" src="../img/zonemaps/zone6.png" alt="grow zones map" v-if="this.$store.state.userData.region == '6a' || this.$store.state.userData.region == '6b'">
          <img class="zonemap" src="../img/zonemaps/zone7.png" alt="grow zones map" v-if="this.$store.state.userData.region == '7a' || this.$store.state.userData.region == '7b'">
          <img class="zonemap" src="../img/zonemaps/zone8.png" alt="grow zones map" v-if="this.$store.state.userData.region == '8a' || this.$store.state.userData.region == '8b'">
          <img class="zonemap" src="../img/zonemaps/zone9.png" alt="grow zones map" v-if="this.$store.state.userData.region == '9a' || this.$store.state.userData.region == '9b'">
          <img class="zonemap" src="../img/zonemaps/zone10.png" alt="grow zones map" v-if="this.$store.state.userData.region == '10a' || this.$store.state.userData.region == '10b'">
          <h1>Zone {{this.$store.state.userData.region}}</h1>
        <h2>{{this.$store.state.userData.city}}, {{this.$store.state.userData.state}} {{this.$store.state.userData.zipcode}}</h2>
      </div>
          <h3 class="growing-info">The Growing Season starts {{this.$store.state.zone.avgLastFrostMonth}} {{this.$store.state.zone.avgLastFrostDay}} and ends {{this.$store.state.zone.avgFirstFrostMonth}} {{this.$store.state.zone.avgFirstFrostDay}}</h3>
      <h3 class="growing-info">On average, there are {{this.$store.state.zone.avgGrowingDays}} growing days per year</h3>
      <br>
      <h2>Suggested vegetables for Zone {{this.$store.state.userData.region}}:</h2>
      <div class="info">

        <div class="zoneplant" v-for="zonePlant in $store.state.zonePlants" v-bind:key="zonePlant.name">
          <img class="zoneplantimg" v-bind:src="require('../img/vegetables/' + zonePlant.name + '.png')"/>
          <h3 id="zoneplantname">{{zonePlant.name}}</h3>
        </div>

      </div>
  </div>
<br>

    <div class="otherzones-start">
        <h2>See other Hardiness Zones</h2>
        <select name="mapValue" id="hzones-select" v-on:change="myFunction()" v-model="mapValue">
          <option selected default value="1">Choose Zone</option>
          <option value="3">Zones 3A and 3B</option>
          <option value="4">Zones 4A and 4B</option>
          <option value="5">Zones 5A and 5B</option>
          <option value="6">Zones 6A and 6B</option>
          <option value="7">Zones 7A and 7B</option>
          <option value="8">Zones 8A and 8B</option>
          <option value="9">Zones 9A and 9B</option>
          <option value="10">Zones 10A and 10B</option>
        </select>
        
          <img class="zonemap" src="../img/zonemaps/zone3.png" alt="grow zones map" v-show="mapValue == '3'">
        <h1 id="zone3" v-show="mapValue == '3'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '3'">Growing Season start: May 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '3'">Growing Season end: September 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '3'">Total growing days per year: 123</h3>
          <img class="zonemap" src="../img/zonemaps/zone4.png" alt="grow zones map" v-show="mapValue == '4'">
        <h1 id="zone4" v-show="mapValue == '4'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '4'">Growing Season start: May 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '4'">Growing Season end: October 1st</h3>
        <h3 class="growing-info" v-show="mapValue == '4'">Total growing days per year: 139</h3>
          <img class="zonemap" src="../img/zonemaps/zone5.png" alt="grow zones map" v-show="mapValue == '5'">
        <h1 id="zone5" v-show="mapValue == '5'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '5'">Growing Season start: May 1st</h3>
        <h3 class="growing-info" v-show="mapValue == '5'">Growing Season end: October 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '5'">Total growing days per year: 168</h3>
          <img class="zonemap" src="../img/zonemaps/zone6.png" alt="grow zones map" v-show="mapValue == '6'">
        <h1 id="zone6" v-show="mapValue == '6'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '6'">Growing Season start: April 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '6'">Growing Season end: October 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '6'">Total growing days per year: 183</h3>
          <img class="zonemap" src="../img/zonemaps/zone7.png" alt="grow zones map" v-show="mapValue == '7'">
        <h1 id="zone7" v-show="mapValue == '7'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '7'">Growing Season start: April 1st</h3>
        <h3 class="growing-info" v-show="mapValue == '7'">Growing Season end: October 31st</h3>
        <h3 class="growing-info" v-show="mapValue == '7'">Total growing days per year: 213</h3>        
          <img class="zonemap" src="../img/zonemaps/zone8.png" alt="grow zones map" v-show="mapValue == '8'">
        <h1 id="zone8" v-show="mapValue == '8'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '8'">Growing Season start: March 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '8'">Growing Season end: November 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '8'">Total growing days per year: 245</h3>  
          <img class="zonemap" src="../img/zonemaps/zone9.png" alt="grow zones map" v-show="mapValue == '9'">
        <h1 id="zone9" v-show="mapValue == '9'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '9'">Growing Season start: February 15th</h3>
        <h3 class="growing-info" v-show="mapValue == '9'">Growing Season end: November 30th</h3>
        <h3 class="growing-info" v-show="mapValue == '9'">Total growing days per year: 290</h3>  
          <img class="zonemap" src="../img/zonemaps/zone10.png" alt="grow zones map" v-show="mapValue == '10'">
        <h1 id="zone10" v-show="mapValue == '10'">Zone {{mapValue}}</h1>
        <h3 class="growing-info" v-show="mapValue == '10'">Growing Season start: January</h3>
        <h3 class="growing-info" v-show="mapValue == '10'">Growing Season end: December 31st</h3>
        <h3 class="growing-info" v-show="mapValue == '10'">Total growing days per year: 290</h3>  
    </div>



  </div>
</template>

<script>


  import ZoneService from "../services/ZoneService";

export default {
  created() {
    ZoneService.getZoneInfo(this.$route.params.zonename)
      .then((response) => {
        this.$store.commit("SET_ZONE", response.data);
      });

    ZoneService.getZonePlants(this.$route.params.zonename)
      .then((response) => {
        this.$store.commit("SET_ZONE_PLANTS", response.data);
      })
  },

  methods: {
     myFunction() {
      let element = document.querySelector(".otherzones-start");
      element.classList.add("otherzones-selected");
  }
  },
  name: "zone-data",
  components: {},
  data() {
    return {
      mapValue: "1",
      zonePlant: {
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
};
</script>

<style>

  h3.description {
    display: flex;
    justify-content: center;
    padding: 0px 50px 0px 50px;
    max-width: 90%;
  }

  .growing-info {
    justify-content: center;
  }

  .info {
    margin: 20px 30px;
    padding: 10px 0px 30px 0px;
    border-radius: 20px;
    display: flex;
    justify-content: center;
  }

  .zoneplant {
    border-color: aliceblue;
    border-radius: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0px 5px;
    padding: 3px 3px;
    background-image: url("../img/vegetables/None.png");
    background-size: 350px;
    max-width: 180px;
  }

  .zoneplantimg {
    width: 70%;
  }

  #zoneplantname {
    justify-content: center;
    margin-bottom: 15px;
    color: white;
    text-shadow: 5px 5px 3px #3b3b3b;
  }



  .page {
    display: flex;
  }

  .zonemap {
    display: flex;
    text-align: center;
    width: 400px;
    display: inline-block;
  }

  .map {
    text-align: center;
    background-color: #85A183;
    border-radius: 50px;
    padding: 50px 30px 50px 30px;
    margin-left: 30px;
  }

  .otherzones-start {
    text-align: center;
    width: 500px;
    border-radius: 50px;
    margin: 0px 10px 0px 10px;
    padding: 50px 50px 50px 50px;
  }

  .otherzones-selected {
    text-align: center;
    background-color: #c1d8bf;
    border-radius: 50px;
    margin: 0px 50px 0px 50px;
    padding: 0px 20px 0px 20px;
    height: 700px;
  }

  #hzones-select {
    font-size: 16px;
    font-family: sans-serif;
    font-weight: 700;
    color: #444;
    line-height: 1.5;
    padding: .6em 1.4em .5em .8em;
    border: 1px solid #aaa;
    box-shadow: 0 2px 0 2px rgba(0,0,0,.04);
    border-radius: .5em;
    appearance: none;
    background-color: #fff;
    background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%);
    background-repeat: no-repeat, repeat;
    background-position: right .7em top 50%, 0 0;
    background-size: .65em auto, 100%;
  }

  #zone3 {
    font-size: 45px;
    color: #E58BE1;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone4 {
    font-size: 45px;
    color: #886FB1;
    text-shadow: 3px 3px 3px #5f5f5f;
  }
  
  #zone5 {
    font-size: 45px;
    color: #80ACFB;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone6 {
    font-size: 45px;
    color: #49AD4B;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone7 {
    font-size: 45px;
    color: #AFE651;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone8 {
    font-size: 45px;
    color: #F9EA61;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone9 {
    font-size: 45px;
    color: #DFBA45;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

  #zone10 {
    font-size: 45px;
    color: #E48028;
    text-shadow: 3px 3px 3px #5f5f5f;
  }

</style>
