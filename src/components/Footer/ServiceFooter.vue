<template>
  <div class="d-flex justify-content-end align-items-center mi my-1">
      <img src="../../assets/img/h0.png" alt="" srcset="">
      <div class="">{{title}}</div>
  </div>
</template>

<script>
export default {
    props:{title:String}
}
</script>

<style scoped>
.mi{direction: rtl}
img {
  width: 22px;
  height: 22px;
}
div{
      
font-family:IRANSansWeb_Bold !important;
font-size: 0.7rem;
    color:#707381
}

.left {
  transform: rotate(135deg);
  -webkit-transform: rotate(135deg);
}
</style>