<template>
  <div>

    <h1>Welcome to Old McDonald's Garage</h1>
    <div class="garage-container">
        <router-link class="vehicle" id="jeep" to="/jeep">
            <h2>Jungle Jeep</h2>
        </router-link>
        <router-link class="vehicle" id="submarine" to="/submarine">
            <h2>Submarine</h2>
        </router-link>
        <router-link class="vehicle" id="rocket" to="/rocket">
            <h2>Rocket</h2>
        </router-link>
        <drouter-link class="footer">
            <h3>Feeling bored with seeing and hearing only his farm animals, Old McDonald wants to explore.</h3>
            <h3>Select a vehicle to travel to different regions and discover new animals!</h3>
        </drouter-link>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.garage-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-rows: 2fr 2fr 1fr;

    grid-template-areas:
        "jeep jeep rocket"
        "submarine submarine rocket"
        "footer footer footer";
    background-color: cadetblue;
    width: auto;
    height: 75vh;
    margin: 0px 100px 50px 100px;
    border-radius: 10px;
}

.vehicle {
    border-style: solid;
    border-radius: 10px;
    border-color: mistyrose;
    background-color: rgb(112, 112, 228);
    margin: 10px;
    text-align: center;
    text-justify: center;
    color:rgb(206, 209, 201);
}

#jeep {
    grid-area: jeep;
    background-image: url("../assets/jeep.jpg");
    background-repeat: no-repeat;
    background-size: contain;
}

#submarine {
    background-image: url("../assets/submarine.jpg");
    background-repeat: no-repeat;
    background-size: contain;
    grid-area: submarine;
}

#rocket {
    grid-area: rocket;
    background-image: url("../assets/rocket.jpg");
    background-repeat: no-repeat;
    background-size: cover;
}

.footer {
    border-style: solid;
    border-radius: 10px;
    border-color: mistyrose;
    grid-area: footer;
    margin: 10px;
    color:rgb(206, 209, 201);
    background-color: rgb(112, 112, 228);
}

</style>