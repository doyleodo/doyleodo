<template>
  <div>
    

<div class="profile-details bubble-block">
      <h2>Profile Details:</h2>
      <div class="profile-field">
        <span class="label-field">Username:</span>
        <span>{{this.$store.state.user.username}}</span>
      </div>
      <div class="profile-field">
        <span class="label-field">Name:</span>
        <span>{{this.$store.state.userData.firstName}} {{this.$store.state.userData.lastName}}</span>
      </div>
      <div class="profile-field">
        <span class="label-field">Email:</span>
        <span>{{this.$store.state.userData.email}}</span>
      </div>
      <div class="profile-field">
        <span class="label-field">City, State Zip:</span>
        <span>{{this.$store.state.userData.city}}, {{this.$store.state.userData.state}} {{this.$store.state.userData.zipcode}}</span>
      </div>
      <div class="profile-field">
        <span class="label-field">Hardiness Zone:</span>
        <span>{{this.$store.state.userData.region}} <router-link class="zonelink" :to="{ name: 'zone'}">View my region details</router-link> </span>
      </div>

      <div class="button-container">
        <router-link
          :to="{ name: 'edit-profile', params: {userID: $route.params.userID} }"
          class="btn-edit btn-profile"
        >Edit Profile</router-link>

        <a href="#" class="btn-delete btn-profile" v-on:click="deleteUser">Delete Profile</a>
      </div>
    </div>

  </div>
</template>

<script>
import userService from "../services/UserService";
import GardenService from "../services/GardenService";


export default {
  created() {
    userService
      .getUserInfo(this.$store.state.user.id)
      .then((response) => {
        this.$store.commit("SET_USER_DATA", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("User Data not available.");
          this.$router.push("/");
        }
      });
    GardenService.getGardensByUserId(this.$store.state.user.id)
      .then((response) => {
        this.$store.commit("SET_GARDENS", response.data);
      })
      .catch((error) => {
        if (error.response && error.response.status === 404) {
          alert("Garden Data not available.");
          this.$router.push("/");
        }
      });
  },

  name: "profile-data",
  components: {},
  data() {
    return {};
  },
  methods: {
    deleteUser() {
      if (
        confirm(
          "Are you sure you want to delete this user? This action cannot be undone."
        )
      ) {
        userService
          .deleteUser(this.user.id)
          .then((response) => {
            if (response.status === 200) {
              alert("User successfully deleted");
              this.$router.push(`/`);
            }
          })
          .catch((error) => {
            if (error.response) {
              this.errorMsg =
                "Error deleting user. Response received was '" +
                error.response.statusText +
                "'.";
            } else if (error.request) {
              this.errorMsg =
                "Error deleting user. Server could not be reached.";
            } else {
              this.errorMsg =
                "Error deleting user. Request could not be created.";
            }
          });
      }
    },
  },
};
</script>

<style local>
h2 {
  margin-bottom: 10px;
}
.bubble-block {
  display: flex;
  flex-direction: column;
  padding: 0px 30px 15px;
  align-content: center;
  border-radius: 25px;
  margin-bottom: 30px;
}

.profile-details {
  background-color: white;
  border: 1px solid white;
}

.garden-listing {
  background-color:  #e48438;
  border: 1px solid  #e48438;
}

.profile-field {
  display: flex;
  margin: 3px 0px;
}

.label-field {
  width: 14ch;
}
.button-container {
  display: flex;
  flex-grow: 1;
  justify-content: center;
  margin-top: 20px;
}

.btn-profile {
  color: #fff;
  text-align: center;
  width: 150px;
  border-radius: 15px;
  line-height: 1.7em;
  font-size: 1.1em;
  text-decoration: none;
  border-style: solid;
  margin: 0px 10px;
}

.btn-edit, .btn-add-garden:hover {
  background-color: #85a183;
  border-color: #85a183;

}
.btn-delete {
  background-color: #e48438;
  border-color: #e48438;
}
.btn-delete:hover {
  background-color: black;
  border-color: black;
}

.btn-add-garden, .btn-edit:hover, .garden-links:hover {
  color: white;
  background-color: #307c55;
  border-color: #307c55;
}

.garden-links {
  display: inline-block;
  color: black;
  text-decoration: none;
  padding: 2px 10px;
  margin: 3px 6px;
  background-color: #c1c65d;
  border: 1px solid #c1c65d;
  border-radius: 5px;
}
</style>
