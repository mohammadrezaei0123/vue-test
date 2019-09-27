<template>
  <div class="d-flex align-items-center mb-auto">
    <div class="pr-2 clb">{{title}}</div>
    <!-- <svg id="i-chevron-left" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" width="15" height="15" fill="none" stroke="currentcolor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2">
    <path d="M20 30 L8 16 20 2" />
</svg> -->
    <!-- <p>{{arrow}}</p> -->
      <!-- <img class="pl-1" src="../../assets/img/arrow.png"> -->
      <i class="arrow left"></i>
  </div>
</template>

<script>
export default {
props:['title'],
// data(){
//     return{
//         arrow:"<"
//     }
// }
}
</script>

<style scoped>
div{
  
font-family:IRANSansWeb !important;
font-size: 0.6rem;
color:mediumturquoise;
}
i {
  border: solid #37b9c5;
  border-width: 0 2px 2px 0;
  display: inline-block;
  padding: 3px;
}


.left {
  transform: rotate(135deg);
  -webkit-transform: rotate(135deg);
}
/* img{
  width: 8px;
  height: 10px;
} */

</style>