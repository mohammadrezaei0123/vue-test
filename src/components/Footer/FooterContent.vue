<template>
  <div class="container-fluid re">
      <div class="row re">
          
      <BottomGradintBack/>
          <div class="col-2 d-flex flex-column align-items-end re">
              <RightGradintBack/>
              <h6>شبکه‌های اجتماعی</h6>
              <div class="d-flex justify-content-between">
                  <img class="sp px-1"  src="../../assets/img/x.png">
                  
                  <img class="sp px-1" src="../../assets/img/face.png">
                  
                  <img class="sp px-1" src="../../assets/img/twitter.png">
              </div>
          </div>
          <div class="col-2 d-flex flex-column align-items-end">
              <h6>صفحات مفید</h6>
              <PageFooter v-for="(pa,i) in pageList" :key="i" :title="pa"/>
          </div>
          <div class="col-3 d-flex flex-column align-items-end">
              <h6>خدمات</h6>
              <ServiceFooter v-for="(pa,i) in serviseList" :key="i" :title="pa"/>
          </div>
          <div class="col-5">
              <AboutUsFooter/>
          </div>
      </div>
  </div>
</template>

<script>
import ServiceFooter from './ServiceFooter'
import PageFooter from './PageFooter'
import BottomGradintBack from "../Background/BottomGradintBack";

import RightGradintBack from "../Background/RightGradintBack";
import AboutUsFooter from './AboutUsFooter'
export default {
    components:{PageFooter,ServiceFooter,AboutUsFooter,BottomGradintBack,RightGradintBack},
data(){
    return{
        pageList:["خانه",
            "لیست پزشکان",
            " اخبار و مقالات",
            "همایش ها",
            "درباره ما",
            "تماس با ما"],
            serviseList:[
"خرید اشتراک های ویژه",
"دوره های آموزشی ویژه"
            ]
    }
}
}
</script>

<style scoped>
h6{
font-family:IRANSansWeb_Bold !important;
font-size: 0.7rem;
    color:#2593d5;
}
.re{
    position: relative;
}
.sp{
    width: 22px;
    height: 18px;
}
</style>