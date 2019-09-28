<template>
  <div class="form-li-blue-border d-flex flex-column p-2 align-items-end m-2 main mr-3">
      <!-- <img src="../../assets/img/h0.png" alt=""> -->
<ArrowTitle title="مشخصات زیر را به دقت بخوانید و مطمئن شوید که همه چیز مورد تاد شماست"/>
     <div class="container mt-1">
         <div class="row">
             
             <div class="col d-flex flex-column">
                 <CostCard cost="25500000"/>
                <Hint/>
             </div>
             <div class="col">
                  <InlineInfoCard title="تاریخ نوبت:" :srcIcon="img1" value="دوشنبه 25 شهریور 1398"/>
     <!-- <InlineInfoCard title="ساعت مراجه:" :srcIcon="img2" value="16:30 بعد از ظهر"/> -->
      <InlineInfoCard title="ساعت مراجه:" :srcIcon="img2" :value="$store.getters.printChooseValue"/>
      <InlineInfoCard title="نام پزشک:" :srcIcon="img3" value="دکتر علیرضا بخشی / قلب و عروق"/>
</div>
         </div>
     </div>
      <div class="container mb-1 mt-3">
          <div class="row">
              <div class="offset-3 col-5">
                   <button type="button" @click="$emit('choose',3)" class="btn btn-sm text-light w-100 d-flex justify-content-center align-items-center">ثبت نهایی و پرداخت<img class="ml-2" src="../../assets/img/yes.png" alt="" srcset=""></button>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import ArrowTitle from "./ArrowTitle";
import CostCard from "./CostCard";
import InlineInfoCard from "./InlineInfoCard";
// import Calnder from "./Calnder";
// import TimeContent from "./TimeContent";
import img1 from '../../assets/img/chart.png'
import img2 from '../../assets/img/time.png'
import img3 from '../../assets/img/reserve.png'
import Hint from './Hint'
export default {
components:{
    InlineInfoCard,ArrowTitle,CostCard,Hint
},
data(){
    return{
        img1:img1,
        img2:img2,
        img3:img3,
    }
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