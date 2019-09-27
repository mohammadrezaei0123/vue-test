<template>
  
    <div class="b-shape mt-n5"></div>
</template>

<script>
export default {

}
</script>

<style scoped>
.b-shape{
    background-image: linear-gradient(#dbeff6, #fff, #dbeff6);
  width:6rem;
  height:6rem;
  position: absolute;
  top: 0;
  /* transform: scale(1.5);
  border-right: 5px;
  border-bottom: 5px; */
      border-top-right-radius: 50% ;
    border-top-left-radius: 50% ;
     /* border-top-right-radius: 50% ; */
    border-bottom-right-radius: 50% ;
    
    border-bottom-left-radius: 50% ;
    z-index: -1
}
</style>