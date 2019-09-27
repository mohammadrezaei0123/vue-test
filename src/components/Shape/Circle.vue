<template>
<div class="main position-absolute">
  <div v-if="!isActive" class="rounded-circle bg-info1 position-absolute not-active"></div>
  
  <div v-if="isActive" class="rounded-circle  position-absolute active d-flex justify-content-center align-items-center">
    <div class=" rounded-circle inside-active bg-info1"></div>
  </div>
</div>
</template>

<script>
export default {
 props:{
   isActive:Boolean
 }
}
</script>

<style scoped>
.bg-info1{
  background: #caeaf5;
}
.main{
top:1rem;
width:1rem ;
height: 1rem;
z-index: 5;
margin-left:-0.4rem;
}
.not-active{
width:100% ;
height: 100%;
}
.active{
width:1rem ;
height: 1rem;
border: 1px solid #caeaf5;
}
.inside-active{
width:0.6rem ;
height:0.6rem;
}

</style>