<template>
<nav class="navbar navbar-expand-lg navbar-dark bg-transparent px-3 py-4">
    <div class="container-fluid m-0 p-0 bg-transparent">
        <div class="col-2 d-flex justify-content-center align-items-center">
<button type="button" class="btn  btn-info l btn-sm px-3">ثبت نام</button>
<button type="button" class="btn btn-transparent btn-sm v">ورود</button>
        </div>
        <div class="col-6 offset-1 bg-transparent  d-flex flex-row-revrese justify-content-around flex-nowrap">
          <MenuItem  value="خانه"/>
          <MenuItem  value="خدمات ما"/>
          <MenuItem  value="اخبار و مقالات"/>
          <MenuItem  value="همایش‌ها"/>
          <MenuItem  value="درباره ما"/>
          <MenuItem  value="تماس با ما"/>
        </div>
        <div class="col-3 ">
        <img src="../../assets/img/logo.png" >
        </div>
    </div>
    
</nav>
</template>

<script>
import MenuItem from "./MenuItem";
export default {
  components:{
    MenuItem
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.btn{
  
font-family:IRANSansWeb !important;
font-size: 0.70rem;
}
.v{
  color: #26b3c7;
}
.mn{
color: #51badc;
}
.l{
  
    background-image: linear-gradient(45deg,#20abc2,  #14c8d1);
    max-height: 2rem;
    border-radius: 12px
}
img{
  max-width: 40px;
  max-height: 40px;
}
</style>
