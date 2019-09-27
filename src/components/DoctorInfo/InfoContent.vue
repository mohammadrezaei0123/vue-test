<template>
  <div class="d-flex flex-column  my-2 mt-3 content position-relative">
    <RectDotted :style='"margin-right :-40%;transform:translateX(-400px)"'/>
      <TopHeader></TopHeader>
      <DoctorInfo name="دکتر علیرضا شاهدوستی" :imgSrc="im2"  doctorInfo="متخصص و جراح بیماریهای چشم" code="50"></DoctorInfo>
  </div>
</template>

<script>
import TopHeader from "./TopHeader";
import DoctorInfo from "./DoctorInfo";
import im1 from '../../assets/img/doctor.png'
import RectDotted from "../Shape/RectDotted";
export default {
components:{
DoctorInfo,
RectDotted,
TopHeader
},data(){
  return{
    im2:im1
  }
}
}
</script>

<style scoped>
.content{
  margin :0 40%;
}
</style>