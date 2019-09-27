<template>
  <div class="d-flex flex-column justify-content-center align-items-center">
      <img :src="srcIcon" class="mt-1">
      <span>{{title}}</span>
  </div>
</template>

<script>
export default {
    props:["title","srcIcon"]
}
</script>
<style scoped>
img{
  width:2rem;
  height: 2rem;

}
span{
  
font-family:IRANSansWeb_bold !important;
font-size: 0.4rem;
color:#5ec7d1;
}

</style>