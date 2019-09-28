<template>
<div class="h-100 position-absolute">
<div :class="(!isPass)?'b h-100 position-absolute mt-4':'b1 h-100 position-absolute mt-4'">
  <!-- <div :class="(isE)?'open p-0':'close p-0'"></div> -->
</div>
</div>
  
</template>

<script>
export default {
mounted(){
  // let self=this
  // setTimeout(function () {
  //   self.isE=true
  //   console.log("isE"+self.isE)
  // },10000)
},
props:{
  isPass:{type:Boolean,
default:false}
}
// data(){
//   return{isE:false}
// }
}
</script>

<style scoped>
div{transition: all 2s;}
.close{
  width: 3px;
  height: 0;
  background: yellow;
z-index: 42;
}
.open{
  width: 3px;
  height: 100%;
background: red;
z-index: 42;
}
.b{
    /* width: 3px; */
    /* width: 3px; */
    border-left: 3px dotted #caeaf5;
    transition: all 3s;
}
.b1{
    /* width: 3px; */
    /* width: 3px; */
    border-left: 3px dotted #176881;
    transition: all 3s;
}
</style>