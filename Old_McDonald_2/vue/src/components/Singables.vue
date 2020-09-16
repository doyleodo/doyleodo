<template>
  <div>
    <div v-for="singable in this.$store.state.singables" v-bind:key="singable.index">

    </div>
  </div>
</template>

<script>
import SingableService from "../services/SingableService";

export default {

  created() {
    SingableService.getAllSingables()
      .then((response) => {
        this.$store.commit("SET_SINGABLES", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Plant data not available.");
          this.$router.push("/");
        }
      });
  },
    data() {
    return {
      singable: {
        id: "",
        singableName: "",
        description: "",
        isVehicle: "",
        sound: "",
        region: "",
      },
    };
  }
}
</script>

<style>

</style>