<template>
  <div class="container-fluid m-0 p-0 w-100">
      <div class="row ">
          <div class="col-8 my-auto">
            <div class="d-flex flex-column justify-content-between align-items-end">
              <div class="d-flex justify-content-end align-items-center">
                <h6 class="mr-2 d-flex justify-content-center align-items-center c">{{name}}</h6>
                <img class="mr-n4" src="../../assets/img/check.png" width="11" height="11">
              </div>
              <span>{{doctorInfo}}</span>
              <span>کد نظام پزشکی:{{code|convertEnToFaDig}}</span>
            </div>
          </div>
          <div class="col-4">
            
        <img class="m-img" :src="imgSrc" >
          </div>
      </div>
  </div>
</template>

<script>
export default {
props:['name','imgSrc','doctorInfo','code']
}
</script>

<style scoped>
.m-img{
  width: 80px;
  height: 80px;
}
h6{
  
  font-weight: bold;
font-family:IRANSansWeb_Bold !important;
font-size: 0.8rem;
}
/* .te{
  margin-right: -2px
} */
span{
  font-family:IRANSansWeb_light !important;
font-size: 0.5rem
}
</style>