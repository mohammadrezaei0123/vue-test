<template>
  <div class="form-li-blue-border d-flex flex-column p-2 align-items-end m-2 mr-3">
      <ArrowTitle title=":لطفا زمان نوبت دلخواه خود را از بین نوبتهای خالی پزشک انتخاب کنید"/>
      <div class="container">
          <div class="row">
              <div class="offset-2 col-8">
                  <Calnder/>
              </div>
          </div>
      </div>
      <TimeContent/>
      <TimeContent :isMorning="false"/>
     <div class="container">
          <div class="row">
              <div class="offset-3 col-5">
                   <button type="button" class="btn btn-sm text-light w-100 d-flex justify-content-center align-items-center">انتخاب نوبت<img class="ml-2" src="../../assets/img/yes.png" alt="" srcset=""></button>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import ArrowTitle from "./ArrowTitle";
import Calnder from "./Calnder";
import TimeContent from "./TimeContent";

export default {
components:{
    ArrowTitle,Calnder,TimeContent
}
}
</script>

<style scoped>
button{
    
    background-image: linear-gradient(45deg,#20a8c2,#14c8d1);
    max-height: 1.6rem;
    
font-family:IRANSansWeb_bold !important;
font-size: 0.6rem;
}
img{
    height: 0.7rem;
}
 /* .main{
     border:1.5px solid blue;
 } */
</style>