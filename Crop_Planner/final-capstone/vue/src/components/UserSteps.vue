<template>
  <div>
      <div class="steps">
        <div class="step">
            <img class="imgsteps" src="../img/steps/1white.png" alt="">
            <h2 >Specify your garden dimensions</h2>
        </div>
        <div class="step">
            <img class="imgsteps" src="../img/steps/2.png" alt="">
            <h2 class="steps">Add vegetable seedlings to your garden</h2>
        </div>
        <div class="step">        
            <img class="imgsteps" src="../img/steps/3.png" alt="">
            <h2>Generate a shopping list of garden supplies</h2>
        </div>
      </div>

  </div>
</template>

<script>
export default {

}
</script>

<style>
    img {
        text-align: center;
        margin-top: 20px;
    }

    .steps {
        display: flex;
        color: #000000;
        text-align: center;
    }

    .step {
        /* background-color: #c1c56d; */
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: rgba(193,197,109, 0.7);
        border-style: solid;
        border-color: #c1c56d;
        border-radius: 10px;
        border-width: 10px;
        margin: 10px;
        width: 30%;
    }
</style>