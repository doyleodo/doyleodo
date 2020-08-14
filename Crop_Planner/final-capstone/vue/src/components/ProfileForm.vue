<template>
  <form v-on:submit.prevent="submitForm" class="profileForm-form">
    <div class="status-message error" v-show="errorMsg !== ''">{{errorMsg}}</div>
    <div class="form-group">
      <div class="fieldgroup">
        <label for="email">Current Email:</label>
        <input
          id="email"
          type="email"
          class="form-control"
          v-model="userData.email"
          autocomplete="off"
        />
      </div>
      <div class="fieldgroup">
        <label for="firstname">Current First name:</label>
        <input
          id="firstname"
          type="text"
          class="form-control"
          v-model="userData.firstName"
          autocomplete="off"
        />
      </div>
      <div class="fieldgroup">
        <label for="lastname">Current Last name:</label>
        <input
          id="lastname"
          type="text"
          class="form-control"
          v-model="userData.lastName"
          autocomplete="off"
        />
      </div>
      <div class="fieldgroup">
        <label for="city">Current City:</label>
        <input
          id="city"
          type="text"
          class="form-control"
          v-model="userData.city"
          autocomplete="off"
        />
      </div>
      <div class="fieldgroup">
        <label for="state">Current State:</label>
        <input
          id="state"
          type="text"
          class="form-control"
          v-model="userData.state"
          autocomplete="off"
        />
      </div>
      <div class="fieldgroup">
        <label for="zipcode">Current Zip:</label>
        <input
          id="zipcode"
          type="text"
          class="form-control"
          v-model="userData.zipcode"
          autocomplete="off"
        />
      </div>
    </div>

    <div id="btn-container-profileform">
      <button class="btn-submit" type="submit">Submit</button>
      <button class="btn-cancel" v-on:click.prevent="cancelForm" type="cancel">Cancel</button>
    </div>
  </form>
</template>



<script>
import userService from "../services/UserService";

export default {
  name: "profile-form",
  props: {
    userID: {
      type: Number,
      default: 0,
    },
  },
  data() {
    return {
      userData: {
        email: this.$store.state.userData.email,
        firstName: this.$store.state.userData.firstName,
        lastName: this.$store.state.userData.lastName,
        city: this.$store.state.userData.city,
        state: this.$store.state.userData.state,
        zipcode: this.$store.state.userData.zipcode,
        id: this.$store.state.userData.id,
      },

      errorMsg: "",
    };
  },
  methods: {
    submitForm() {
      userService
        .updateUserInfo(this.userData)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("SET_USER_DATA", response.data);
            this.$router.push(`/profile/`);
          }
        })
        .catch((error) => {
          if (error.response) {
            this.errorMsg =
              "Error updating info. Response received was '" +
              error.response.statusText +
              "'.";
          } else if (error.request) {
            this.errorMsg = "Error updating info. Server could not be reached.";
          } else {
            this.errorMsg =
              "Error updating info. Request could not be created.";
          }
        });
    },
    cancelForm() {
      this.$router.push(`/profile/`);
    },
  },
  created() {
    if (this.userID != 0) {
      userService
        .getUserInfo(this.userID)
        .then((response) => {
          this.user = response.data;
        })
        .catch((error) => {
          if (error.response && error.response.status === 404) {
            alert(
              "Profile not available. This user may have been deleted or you have entered invalid info."
            );
            this.$router.push("/");
          }
        });
    }
  },
};
</script>


<style>
.profileForm-form {
  display: flex;
  flex-direction: column;
  width: 60%;
}
.fieldgroup {
  display: flex;

}

.cardForm {
  padding: 10px;
  margin-bottom: 10px;
}
.form-group {
  margin-bottom: 10px;
  margin-top: 10px;
}
label {
  display: inline-block;
  margin-bottom: 0.5rem;
}
.form-control {
  display: block;
  width: 80%;
  height: 30px;
  padding: 0.375rem 0.75rem;
  font-size: 1rem;
  font-weight: 400;
  line-height: 1.5;
  color: #495057;
  border: 1px solid #ced4da;
  border-radius: 0.25rem;
}
textarea.form-control {
  height: 75px;
  font-family: Arial, Helvetica, sans-serif;
}
select.form-control {
  width: 20%;
  display: inline-block;
  margin: 10px 20px 10px 10px;
}

.btn-submit {
  color: #fff;
  background-color: #e48438;
  border-color: #e48438;
  width: 150px;
  margin-right: 15px;
  border-radius: 5px;
  margin-top: 15px;
}
.btn-cancel {
  color: #fff;
  background-color: #307c55;
  border-color: #307c55;
  width: 150px;
  border-radius: 5px;
  margin-left: 10px;
}

.status-message {
  display: block;
  border-radius: 5px;
  font-weight: bold;
  font-size: 1rem;
  text-align: center;
  padding: 10px;
  margin-bottom: 10px;
}
.status-message.success {
  background-color: #90ee90;
}
.status-message.error {
  background-color: #f08080;
}

.button {
  padding: 20px;
  height: 28px;
  border-radius: 28px;
  width: 80px;
  margin-left: 20px;
  color: white;
  font-size: 1.2em;
  font-weight: 200;
  text-align: center;
  text-decoration: none;
  align-items: center;
  background-color: #e48438;
}

#btn-container-profileform {
  display: flex;
  flex-grow: 1;
  justify-content: center;
}
</style>
