<template>
  <div class="d-flex align-items-center parent">
      <img :src="srcIcon" class="">
        <div class="border-bottom d-flex justify-content-end align-items-center mr-3 pb-1">
            <div class="pl-1 a">{{title}}</div>
            <div class="pl-1 v c">{{value}}</div>
        </div>
  </div>
</template>

<script>
export default {
props:['srcIcon','title','value']
}
</script>

<style scoped>
img{
    height: 12px;
    width: 14px
}
.parent{
    direction: rtl;
    height: fit-content;
    height: 2rem;
}
.border-bottom{
    border-bottom: 1px solid white;
}
div.a{
  
font-family:IRANSansWeb !important;
font-size: 0.5rem;
color:mediumturquoise;
}
div.v{
    font-family:IRANSansWeb_Bold !important;
font-size: 0.6rem;
}
</style>