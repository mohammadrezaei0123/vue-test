<template>
  <div class="container-fluid b-m">
      <div class="row">
          <div class="col-9 offset-2">
              <div class="container-fluid">
      <div class="row mb-1">
          <div class="col-10 d-flex justify-content-end align-items-center">
              <div class="pr-3 c">دریافت نوبت از دکتر علیرضا شاهدوستی</div>
             <img class="mr-n3 f" src="../../assets/img/info.png">
          </div>
      </div>
      <div class="row position-relative no-gutters">
          <div class="col-10 ">
              <Level1/>
          </div>
          <div class="col-2 ">
              <StepLevel step="مرحله اول" value="انتخاب بخش" :isActive="true"/></div>
          <Dotted class="offset-10"/>
      </div>
      <div class="row position-relative no-gutters">
          <div class="col-10 ">
              <Level2/>
          </div>
          <div class="col-2 "><StepLevel step="مرحله دوم" value="زمان حضور در مطب" :isActive="false" /></div>
          <Dotted class="offset-10"/>
      </div>
      <div class="row position-relative no-gutters">
          <div class="col-10 "><Level3/></div>
          <div class="col-2 "><StepLevel step="مرحله سوم" value="تأیید اطلاعات" :isActive="false"/></div>
          <Dotted class="offset-10"/>
      </div>
  </div>
          </div>
      </div>
  </div>
</template>

<script>
import Dotted from '../Shape/Dotted'
import StepLevel from './StepLevel'
import Level1 from './Level1'

import Level2 from './Level2'


import Level3 from './Level3'
export default {
components:{
Dotted,StepLevel,Level1,Level2,Level3
}
}
</script>

<style scoped>
.f{
    height: 20px;
    widows: 20px;
}
.b-m{
margin-bottom: 200px;
}
div{
  
font-family:IRANSansWeb_bold !important;
font-size: 0.7rem;
}
</style>