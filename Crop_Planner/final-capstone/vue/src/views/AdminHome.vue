<template>
  <div id="admin-home-page">
      <h1> Administrative Settings</h1>
    <admin-home />
    <admin-plant-list />
    


</div>
</template>

<script>

import AdminHome from '@/components/AdminHome';
import AdminPlantList from '@/components/AdminPlantList';


export default {
  components: { 
    AdminHome,
    AdminPlantList
    
  }
};
</script>

<style>

#admin-home-page {
  width: 90%;
}

</style>