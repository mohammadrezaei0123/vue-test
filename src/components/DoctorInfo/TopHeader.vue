<template>
  <div class="d-flex flex-column bord w-100">
      <div class="container-fluid no-gutters mb-3">
        <div class="row d-flex justify-content-between flex-nowrap">
          <div class="col-auto p-0">
        <img src="../../assets/img/hearth.png" >
            </div>
          <div class="col-auto p-0">
      <h4 class="c">اطلاعات پزشک</h4>
      </div>
          <div class="col-auto p-0">

            
        <img src="../../assets/img/hearth_1.png" >
          </div>
        </div>
      </div>
      <p class="text-center">نوبت‌دهی اینترنتی از بهترین پزشکان سامانه جامع</p>
  </div>
</template>

<script>
export default {
destroyed(){
window.removeEventListener('scroll',this.scroll)
},
mounted(){
  // this.scroll()
  //  window.addEventListener("scroll",this.scroll)
},methods:{
  scroll(){
    var doc = document.documentElement;
            // var lefta = (window.pageXOffset || doc.scrollLeft) - (doc.clientLeft || 0);
            var newTop =((window.pageYOffset || doc.scrollTop)  - (doc.clientTop || 0));
            // console.log(newTop)
            if(newTop>10){
              this.$el.style.boxShadow="2px 4px 8px 0 #dbeff6"
              this.$el.style.backgroundColor='#fff'
              this.$el.style.borderRadius="5px"
              
              this.$el.style.border="none"
              this.$el.style.paddingTop='1rem'
            }else{
              this.$el.style.boxShadow="none"
              this.$el.style.backgroundColor='transparent'
              
              this.$el.style.border="border-bottom: 1px solid #dbe0e2"
              
              this.$el.style.borderRadius="0"
              this.$el.style.padding='0'
            }
  }
}
}
</script>
<style scoped>
img{
  width: 30px;
  height: 20px;
}
.bord{
  border-bottom: 1px solid #dbe0e2;
}
h4{
  
  font-weight: bold;
font-family:IRANSansWeb_Bold !important;
font-size: 1.2rem;
  white-space: nowrap;

}
p{
    font-family:IRANSansWeb !important;
font-size: 0.6rem
}
</style>