<template>
  <div class="d-flex justify-content-between">
      
      <i class="arrow-down mt-1"></i>
      <div class="d-flex">
          <div class="d-flex flex-column pr-1">
              <h6>انتخاب بخش</h6>
              <span>مشاوره قلب</span>
          </div>
          <img src="../../assets/img/chart.png" class="mt-1" alt="" srcset="">
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
h6{
  
font-family:IRANSansWeb_bold !important;
font-size: 0.7rem;
color:#707381;
}
span{
  
font-family:IRANSansWeb_light !important;
font-size: 0.5rem;
color:#e6d8d9;
}
img{
    width: 0.6rem;
    height: 0.6rem;
}
.arrow-down {
  width: 0; 
  height: 0; 
  border-left: 0.4rem solid transparent;
  border-right: 0.4rem solid transparent;
  
  border-top: 0.5rem solid #05a8b7;
}

</style>