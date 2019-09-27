<template>
  <div class="d-flex flex-column  position-relative align-items-start mt-1">
      <span class="pt-3 pb-1">{{step}}</span>
      <p class="c">{{value}}</p>
      <CircleL :isActive=isActive />
  </div>
</template>

<script>
import CircleL from "../Shape/Circle";
export default {
props:{
    step:String,
    value:String,
    isActive:Boolean
},
components:{
CircleL
}
}
</script>

<style scoped>
span,p{
    padding-left: 1rem
}
p{
  
font-family:IRANSansWeb_bold !important;
font-size: 0.7rem;
}
span{
  
font-family:IRANSansWeb !important;
font-size: 0.5rem;
color: #caeaf5;
}

</style>