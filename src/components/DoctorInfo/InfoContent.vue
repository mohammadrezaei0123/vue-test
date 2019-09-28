<template>
  <div class="d-none d-md-flex flex-column align-items-center  my-2 mt-3 content    sticky-top">
    
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
},
destroyed(){
window.removeEventListener('scroll',this.scroll)
},
mounted(){
  this.scroll()
   window.addEventListener("scroll",this.scroll)
},methods:{
  scroll(){
    var doc = document.documentElement;
            // var lefta = (window.pageXOffset || doc.scrollLeft) - (doc.clientLeft || 0);
            var newTop =((window.pageYOffset || doc.scrollTop)  - (doc.clientTop || 0));
            var p = document.getElementById("tops");
            var style = p.currentStyle || window.getComputedStyle(p);
            let g=(document.getElementById("tops").style.marginTop)
            let t=g.slice(1,g.length-2)
            // console.log(parseInt(t))
            // console.log(style)
            if(newTop>10){
              // this.$el.style.boxShadow="2px 4px 8px 0 #dbeff6"
              // this.$el.style.backgroundColor='rgba(200, 200, 200,0.3)'
              // this.$el.style.borderRadius="5px"
              
              // this.$el.style.border="none"
              this.$el.style.marginLeft='10px'
              this.$el.style.marginRight='85%'
              this.$el.style.top=(parseInt(t)+50)+'px'
            }else{
              // this.$el.style.boxShadow="none"
              // this.$el.style.backgroundColor='transparent'
              
              // this.$el.style.border="border-bottom: 1px solid #dbe0e2"
              
              // this.$el.style.borderRadius="0"
              // this.$el.style.padding='0'
              this.$el.style.margin='0 40%'
              
              this.$el.style.marginTop='0'
              
              this.$el.style.top='0'
            }
  }
}
}
</script>

<style scoped>
.content{
  /* background-size: cover;  */
  margin :0 40%;
  transition: all 1.5s
}
</style>